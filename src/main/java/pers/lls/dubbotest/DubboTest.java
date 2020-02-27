package pers.lls.dubbotest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uyun.pacific.resource.api.service.ResPermissionService;

/**
 *
 */
public class DubboTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo.xml" });
        ResPermissionService resPermissionService = context.getBean(ResPermissionService.class);
        resPermissionService.
//        List<String> alertTenant = alertQueryService.getAlertTenant();
//        List<Alert> alert1 =  alertQueryService.getByIds(Collections.singleton("1250ed99ce5743baaa8bc53e1ea135f0"));
//        System.out.println(alert1.get(0).getName());



    }
}

