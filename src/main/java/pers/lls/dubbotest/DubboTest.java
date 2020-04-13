package pers.lls.dubbotest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uyun.bird.notify.api.EmailEntity;
import uyun.bird.notify.api.NotifyServiceCommon;

import java.util.Collections;

/**
 *
 */
public class DubboTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-dubbo.xml" });
        NotifyServiceCommon notifyServiceCommon = context.getBean(NotifyServiceCommon.class);
        EmailEntity params = new EmailEntity();
        params.setSubject("lls");
        params.setMessage("llsmessage");
        params.setAppId("d9aeedfb874f4fb7b09968c088e699c9");
        params.setActionCode("BUILT_IN_EMAIL");
        params.setSync(true);
        params.setUserIds(Collections.singletonList("ee875bd2692e4f02918219cbdc1ae2a8"));
        notifyServiceCommon.sendEmail(params, "127.0.0.1");
        System.out.println("yes");



    }
}

