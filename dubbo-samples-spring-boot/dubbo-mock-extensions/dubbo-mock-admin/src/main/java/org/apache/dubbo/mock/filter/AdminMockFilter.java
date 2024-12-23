/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.mock.filter;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.dubbo.config.AbstractConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.ReferenceConfigBase;
import org.apache.dubbo.config.utils.ConfigValidationUtils;
import org.apache.dubbo.mock.api.MockContext;
import org.apache.dubbo.mock.api.MockResult;
import org.apache.dubbo.mock.api.MockService;
import org.apache.dubbo.mock.handler.CommonTypeHandler;
import org.apache.dubbo.mock.handler.ResultContext;
import org.apache.dubbo.mock.handler.TypeHandler;
import org.apache.dubbo.mock.utils.ProtobufUtil;
import org.apache.dubbo.rpc.*;
//import org.springframework.web.client.RestTemplate;
//import sun.net.www.http.HttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER_SIDE;
import static org.apache.dubbo.common.constants.CommonConstants.INTERFACE_KEY;
import static org.apache.dubbo.common.constants.CommonConstants.SIDE_KEY;

/**
 * AdminMockFilter will intercept the request from user's consumer. if the mock tag is opened,
 * then the user's consumer will request the mock data configured in Dubbo Admin. The mock data's
 * request is agent by the implement of {@link MockService}.
 */
@Activate(group = CommonConstants.CONSUMER)
public class AdminMockFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(AdminMockFilter.class);

    private static final String ENABLE_MOCK_KEY = "dubbo.admin.mock.enable";
    private final TypeHandler typeHandler = new CommonTypeHandler();
    ;

    private static final boolean ENABLE_ADMIN_MOCK = Boolean.parseBoolean(System.getProperty(ENABLE_MOCK_KEY, Boolean.FALSE.toString()));
//    private static final String MOCK_URL = String.valueOf(System.getProperty(MOCK_URL_KEY, "localhost"));
    private static final String MOCK_URL = "https://localhost/mock2";
    ;

    private static final ProxyFactory proxyFactory = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getAdaptiveExtension();

    private static final Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

    private MockService mockService;

    /**
     * Get the proxy of {@link MockService}. if not exist, then will create a new instance retrun.
     *
     * @return the proxy of {@link MockService}.
     */
    private MockService getMockService() {
        if (Objects.nonNull(mockService)) {
            return mockService;
        }
        synchronized (this) {
            if (Objects.nonNull(mockService)) {
                return mockService;
            }
            // init the config, the registry is from user's config.
            ReferenceConfig<MockService> mockServiceConfig = new ReferenceConfig<>();
            mockServiceConfig.setCheck(false);
            mockServiceConfig.setInterface(MockService.class);
//            mockServiceConfig.setRegistries(DubboBootstrap.getInstance().getConfigManager().getDefaultRegistries());
            List<URL> urls = ConfigValidationUtils.loadRegistries(mockServiceConfig, false);
            if (CollectionUtils.isEmpty(urls)) {
                return null;
            }
            // build the URL parameters
            URL url = urls.get(0);
            Map<String, String> map = new HashMap<>();
            ReferenceConfigBase.appendRuntimeParameters(map);
            map.put(INTERFACE_KEY, MockService.class.getName());
            map.put(SIDE_KEY, CONSUMER_SIDE);
            AbstractConfig.appendParameters(map, mockServiceConfig.getApplication());
            AbstractConfig.appendParameters(map, mockServiceConfig.getModule());
            AbstractConfig.appendParameters(map, mockServiceConfig);
//            url = url.putAttribute(REFER_KEY, map);
            // create the proxy MockService
            Invoker<MockService> invoker = protocol.refer(MockService.class, url);
            mockService = proxyFactory.getProxy(invoker);
//            ScopeModelUtil.getApplicationModel(mockServiceConfig.getScopeModel()).getBeanFactory().getBean(ShutdownHookCallbacks.class)
//                .addCallback(invoker::destroy);
            return mockService;
        }
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // check if open the admin mock config, global config.
        if (!ENABLE_ADMIN_MOCK) {
            return invoker.invoke(invocation);
        }

        String interfaceName = invocation.getTargetServiceUniqueName();
        String methodName = invocation.getMethodName();
        Object[] params = solveParams(invocation.getArguments());

//        // check if the MockService's invoker, then request.
//        if (Objects.equals(interfaceName, MockService.class.getName())) {
//            return invoker.invoke(invocation);
//        }

//        MockService mockService = getMockService();
//        if (Objects.isNull(mockService)) {
//            log.warn("[Admin Mock] cloud not find MockService, will ignore this mock.");
//            return invoker.invoke(invocation);
//        }

        // parse the result from MockService, build the real method's return value.
        MockContext mockContext = MockContext.newMockContext()
            .serviceName(interfaceName).methodName(methodName).arguments(params).build();
//        MockResult mockResult = mockService.mock(mockContext);

        log.info("[Admin Mock] 开始 mock 请求");
        HttpResponse execute = null;
        try {
            execute = HttpUtil.createPost(MOCK_URL).body(mockContext.toString()).execute();
        } catch (Exception e) {
            log.warn("[Admin Mock] mock http请求失败, 忽略mock");
            return invoker.invoke(invocation);
        }
        MockResult mockResult = new Gson().fromJson(execute.body(), MockResult.class);

        if (!mockResult.getEnable()) {
            log.warn("[Admin Mock] 返回体不合规或未开启mock, 忽略mock. body:" + execute.body());
            return invoker.invoke(invocation);
        }

        // parse the return data.
        Class<?> returnType = ((RpcInvocation) invocation).getReturnType();
        ResultContext resultContext = ResultContext.newResultContext()
            .data(mockResult.getContent()).targetType(returnType)
            .serviceName(interfaceName).methodName(methodName).build();
        Object data = typeHandler.handleResult(resultContext);
        AppResponse appResponse = new AppResponse(data);
        CompletableFuture<AppResponse> appResponseFuture = new CompletableFuture<>();
        appResponseFuture.complete(appResponse);
        return new AsyncRpcResult(appResponseFuture, invocation);
    }

    /**
     * Solve the request params, due to the protobuf object has no public constructor.
     * and we use dubbo protocol, so we must solve it.
     *
     * @param arguments arguments
     * @return new resolved params.
     */
    private Object[] solveParams(Object[] arguments) {
        if (Objects.isNull(arguments)) {
            return null;
        }
        Object[] params = new Object[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            Object argument = arguments[i];
            if (Objects.isNull(argument)) {
                params[i] = null;
                continue;
            }
            if (ProtobufUtil.isProtobufClass(argument.getClass())) {
                params[i] = ProtobufUtil.protobufToJson(argument);
            } else {
                params[i] = argument;
            }
        }
        return params;
    }
}
