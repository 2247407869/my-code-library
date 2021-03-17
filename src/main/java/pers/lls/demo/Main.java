package pers.lls.demo;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.RemovalListener;
import uyun.indian.common.cache.Cache;
import uyun.indian.common.cache.CacheBuilder;
import uyun.indian.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Cache<String, String> cache5 = CacheBuilder.newBuilder()
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .maximumSize(100)
                .removalListener((RemovalListener<String, String>) rn -> {
                    System.out.println("123");
                })
                .build();
        LoadingCache<String, String> cache1 = CacheBuilder.newBuilder()
                .name("test2")
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .maximumSize(100)
                .removalListener((RemovalListener<String, String>) rn -> {
                    System.out.println("123");
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String seconds) throws Exception {
                        return "new Object";
                    }
                });
        cache5.put("abc", "123");
        cache1.put("abc","123");
//        cache5.invalidate("abc");
        System.out.println(cache1.getIfPresent("abcd"));
        try {
            System.out.println(cache1.get("abcd"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Thread.sleep(10000);
                System.out.println(cache1.get("abcd"));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

