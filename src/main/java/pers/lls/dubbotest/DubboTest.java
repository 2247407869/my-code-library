package pers.lls.dubbotest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uyun.indian.entity.Alert;
import uyun.indian.reader.api.AlertQueryService;

/**
 *
 */
public class DubboTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo.xml" });
        AlertQueryService alertQueryService = context.getBean(AlertQueryService.class);;
        Alert alert = alertQueryService.getByMergeInfo("e10adc3949ba59abbe56e057f20f88dd",
                "name,entity_name", "minato aqua_PC Server");
        System.out.println(alert.getName());
//        List<String> alertTenant = alertQueryService.getAlertTenant();
//        List<Alert> alert1 =  alertQueryService.getByIds(Collections.singleton("1250ed99ce5743baaa8bc53e1ea135f0"));
//        System.out.println(alert1.get(0).getName());



    }
}

