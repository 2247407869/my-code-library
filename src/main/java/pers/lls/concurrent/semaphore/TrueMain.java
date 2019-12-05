package pers.lls.concurrent.semaphore;

/**
 * @author lils
 */
public class TrueMain {
    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.test();
        semaphoreTest.test();
    }
}
