package pers.lls.concurrent.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lils
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExecutorConfig.class);
        WxTestController wxTestController = context.getBean(WxTestController.class);
        wxTestController.helloWxThread();
    }
}
