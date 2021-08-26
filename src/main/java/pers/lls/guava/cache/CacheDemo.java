//package pers.lls.guava.cache;
//
//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//
//import java.util.concurrent.TimeUnit;
//
///**
// *
// */
//public class CacheDemo {
//
//    public static void main(String[] args) {
//        Cache<String,String> cache = CacheBuilder.newBuilder().build();
//        cache.put("word","Hello Guava Cache");
//        System.out.println(cache.getIfPresent("word"));
//
//        //设置最大存储
//        Cache<String,String> cache2 = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .build();
//        cache2.put("key1","value1");
//        cache2.put("key2","value2");
//        cache2.put("key3","value3");
//        System.out.println("第一个值：" + cache2.getIfPresent("key1"));
//        System.out.println("第二个值：" + cache2.getIfPresent("key2"));
//        System.out.println("第三个值：" + cache2.getIfPresent("key3"));
//
//        // 设置缓存时间
//        Cache<String,String> cache3 = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .expireAfterWrite(3, TimeUnit.SECONDS)
//                .build();
//        cache3.put("key1","value1");
//        int time = 1;
//        while(time<5) {
//            System.out.println("第" + time++ + "次取到key1的值为：" + cache3.getIfPresent("key1"));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // 一段时间未访问后过期
//        Cache<String,String> cache4 = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .expireAfterAccess(3,TimeUnit.SECONDS)
//                .build();
//        cache4.put("key1","value1");
//        int time2 = 1;
//        while(time2 < 6) {
//            try {
//                Thread.sleep(time2*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("睡眠" + time2++ + "秒后取到key1的值为：" + cache4.getIfPresent("key1"));
//        }
//
//        // 异步刷新
//        Cache<String,String> cache5 = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .refreshAfterWrite(3,TimeUnit.SECONDS)
//                .build();
//        cache5.put("key1","value1");
//        cache5.invalidate("key");
//        cache.getIfPresent("key");
//        int time3 = 1;
//        while(time3 < 6) {
//            try {
//                Thread.sleep(time3*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("睡眠" + time3++ + "秒后取到key1的值为：" + cache5.getIfPresent("key1"));
//        }
//    }
//}
