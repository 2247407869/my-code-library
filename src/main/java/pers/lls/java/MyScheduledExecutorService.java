package pers.lls.java;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledExecutorService {
    public static void main(String[] args) {
        // 创建任务队列
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        // 10 为线程数量
        // 执行任务
        scheduledExecutorService.scheduleAtFixedRate(() ->
                System.out.println("Run Schedule：" + new Date()),
                1, 3, TimeUnit.SECONDS);
        // 1s 后开始执行，每 3s 执行一次
    }
}
