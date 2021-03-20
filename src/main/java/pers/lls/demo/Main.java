package pers.lls.demo;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1,2);
    }
}

