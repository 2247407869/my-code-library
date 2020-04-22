package pers.lls.dubbotest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uyun.eagle.datacenter.api.entity.IncidentProperty;
import uyun.eagle.datacenter.api.entity.param.AlertQueryParam;
import uyun.indian.entity.Alert;
import uyun.indian.entity.dict.AlertGroupEnum;
import uyun.indian.entity.param.AlertHistoryParam;
import uyun.indian.entity.param.AlertParam;
import uyun.indian.reader.api.AlertQueryService;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class DubboTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo.xml" });
//
//        NotifyServiceCommon notifyServiceCommon = context.getBean(NotifyServiceCommon.class);
//        EmailEntity params = new EmailEntity();
//        params.setSubject("lls");
//        params.setMessage("llsmessage");
//        params.setAppId("d9aeedfb874f4fb7b09968c088e699c9");
//        params.setActionCode("BUILT_IN_EMAIL");
//        params.setSync(true);
//        params.setUserIds(Collections.singletonList("ee875bd2692e4f02918219cbdc1ae2a8"));
//        notifyServiceCommon.sendEmail(params, "127.0.0.1");
//        System.out.println("yes");

        AlertQueryService alertQueryService = context.getBean(AlertQueryService.class);
        AlertParam param1 = new AlertParam();
//        param1.setBegin(1584259475000L);
//        param1.setEnd(1586937875099L);
        param1.setTenantId("e10adc3949ba59abbe56e057f20f88dd");
        List<Map> value = alertQueryService.countByGroup(param1, AlertGroupEnum.EX_PROP, null);

        System.out.println(JSONObject.toJSONString(value));

        Set<IncidentProperty> incidentPropertiesSet = value.stream()
                .map(map -> { IncidentProperty incidentProperty = new IncidentProperty();
                incidentProperty.setName((String)map.get("propertiesname"));
                incidentProperty.setCode((String)map.get("propertiescode"));
                return incidentProperty;}).collect(Collectors.toSet());

        System.out.println(JSONObject.toJSONString(incidentPropertiesSet));

//        AlertQueryService alertQueryService = context.getBean(AlertQueryService.class);
//        AlertHistoryParam alertHistoryParam = new AlertHistoryParam();
//        alertHistoryParam.setKeyWordsType(100);
//        alertHistoryParam.setKeyWords("123");
//        alertHistoryParam.setKeyName("foo");
//        alertHistoryParam.setQueryType(1);
//        alertHistoryParam.setPageSize(20);
//        alertHistoryParam.setCurrentPage(1);
//        List<Alert> alerts = alertQueryService.queryHistory(alertHistoryParam);
//        System.out.println(JSONObject.toJSONString(alerts));


    }
}

