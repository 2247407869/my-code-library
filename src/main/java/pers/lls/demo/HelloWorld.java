package pers.lls.demo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HelloWorld {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String,String>();
        map.put("1","a");
        map.put("2","b");

        Object o = 1;
        System.out.println(map.get(String.valueOf(o)));
    }
}
