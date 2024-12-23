package pers.lls.concurrent.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-08 14:18
 **/
@Component
public class WxTestController {


    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    public void helloWxThread(){
        setWxTestThread();
    }


    public void setWxTestThread(){
        WxTestThread testThread = new WxTestThread();
        taskExecutor.execute(testThread);
    }
}

