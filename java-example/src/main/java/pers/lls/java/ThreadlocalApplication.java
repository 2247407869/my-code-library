package pers.lls.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadlocalApplication {

    public static ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            exec.execute(() -> {
                threadLocal.set(new byte[1024 * 1024]);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    threadLocal.remove();
                }
//                threadLocal.get();
                System.out.println("完成");
            });

            System.out.println("test" + i);
        }
    }
}