package com.example.demo.filter;

import com.example.demo.config.CommonConfig;
import com.example.demo.util.ZkUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIUtils;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * 转发请求到master节点
 */
@Component
@WebFilter(filterName = "transferFilter", urlPatterns = {"/**"}, asyncSupported = true)
@Slf4j
public class TransferFilter implements Filter {
    @Value("${server.port}")
    String port;

    @Autowired
    MyProxyServlet myProxyServlet;

    public static final String TRANSFER_FILTER_FLAG = "transferFilterFlag";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String leaderIPAddress = ZkUtil.getLeaderIPAddress("/managerLeader");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String transfer = httpServletRequest.getHeader(TRANSFER_FILTER_FLAG);
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (
//                InetAddress.getLocalHost().getHostAddress().equals(leaderIPAddress) ||
                        Boolean.parseBoolean(transfer)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            int base = httpServletRequest.getContextPath().length();
            String url = httpServletRequest.getRequestURI();

            String endpoint = url.substring(base);

            String redirectUrl = CommonConfig.baseUrl.split("//")[0] + "//" + leaderIPAddress + ":" + port + endpoint;

            log.info("origin url: {}, cros redirect url: {}", url, redirectUrl);

            redirect(httpServletRequest, httpServletResponse, redirectUrl);
        }
    }

    public void redirect(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String redirectUrl) throws ServletException, IOException {
//        MyProxyServlet myProxyServlet = new MyProxyServlet();
        myProxyServlet.init(myProxyServlet.getConfig());
        HttpHost targetHost = getHttpHost(redirectUrl);
        httpServletRequest.setAttribute(ProxyServlet.class.getSimpleName() + ".targetUri", redirectUrl);
        httpServletRequest.setAttribute(ProxyServlet.class.getSimpleName() + ".targetHost", targetHost);
        MutableHttpServletRequest mutableHttpServletRequest = new MutableHttpServletRequest(httpServletRequest);
        mutableHttpServletRequest.putHeader(TRANSFER_FILTER_FLAG, "true");
        myProxyServlet.service(mutableHttpServletRequest, httpServletResponse);
    }

    private static HttpHost getHttpHost(String redirectUrl) throws ServletException {
        URI targetUriObj;
        try {
            targetUriObj = new URI(redirectUrl);
        } catch (Exception e) {
            throw new ServletException("Trying to process targetUri init parameter: "+e,e);
        }
        HttpHost targetHost = URIUtils.extractHost(targetUriObj);
        return targetHost;
    }
}
