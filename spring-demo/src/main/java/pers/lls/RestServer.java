package pers.lls;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.spring.SpringContextLoaderListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
 
@Component("restServer")
public class RestServer {
 
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Server restServer;
    private String hostIp = "127.0.0.1";
    private int port = 8097;
 
    @PostConstruct
    public void init(){
        restServer = new Server();
        final List<Connector> connectors = new ArrayList<>();
        ServerConnector connectorV4 = new ServerConnector(restServer);
        connectorV4.setHost(hostIp);
        connectorV4.setPort(port);
        connectors.add(connectorV4);
        logger.info("IPV4 Connector Info:HostIP:"+this.hostIp+", Port:"+this.port);
 
        restServer.setConnectors(connectors.toArray(new Connector[connectors.size()]));
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setContextPath("/");//设置上下文
 
        contextHandler.addEventListener(new ResteasyBootstrap());
        contextHandler.addEventListener(new SpringContextLoaderListener());//instead of ContextLoaderListener
        contextHandler.setInitParameter("contextConfigLocation", "classpath:spring.xml");
 
        ServletHolder holder = new ServletHolder(HttpServletDispatcher.class);
        holder.setInitParameter("resteasy.servlet.mapping.prefix", "/");//resteasy前缀
        holder.setInitOrder(1);
        holder.setAsyncSupported(true);
        contextHandler.addServlet(holder,"/*");//servlet过滤规则
        restServer.setHandler(contextHandler);
        try {
            restServer.start();
        } catch (Exception e) {
            logger.error("rest server start failed!");
            logger.error(e.getMessage(), e);
        }
    }
 
    @PreDestroy
    public void destroy() {
        if(restServer != null){
            try {
                restServer.stop();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
 
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }
 
    public void setPort(int port) {
        this.port = port;
    }
 
    public static void main(String[] args) {
        RestServer resourcePackageRest = new RestServer();
        resourcePackageRest.init();
        System.out.println("rest server started successful!");
    }
}