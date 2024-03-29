package pers.lls.java;

/**
 * vollatie无法保证原子操作
 * @author joonwhee
 * @date 2019/7/6
 */
public class VolatileTest {
    
    public static volatile int race = 0;
 
    private static final int THREADS_COUNT = 20;
    
    public static void increase() {
        race++;
    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
 
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}