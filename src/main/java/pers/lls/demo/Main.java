package pers.lls.demo;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import uyun.indian.common.cache.CacheBuilder;
import uyun.indian.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        LoadingCache<String, String> cache1 = CacheBuilder.newBuilder()
                .name("test2")
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                .maximumSize(100)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String seconds) throws Exception {
                        throw new Exception("error");
                    }
                });
        cache1.put("abc","123");
//        cache5.invalidate("abc");
        System.out.println(cache1.getIfPresent("abc"));
//        try {
//            System.out.println(cache1.get("abc"));
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        while (true){
            try {
                Thread.sleep(5000);
                System.out.println(cache1.get("abc"));
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

