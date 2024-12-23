package pers.lls.java;

public class ThreadLocalDemo {

  public static void main(String[] args) throws InterruptedException {
    // 监视Thread.currentThread().threadLocals
    new Thread(() -> {
      ThreadLocal<String> threadLocal;
      for (int i = 0; i < 20; i++) {
        System.gc();
        threadLocal = new ThreadLocal<>();
        threadLocal.set("test"+ i);
        System.out.println(threadLocal.get());
      }
    }, "thread test ").start();
  }
}