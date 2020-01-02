package pers.lls.demo;

import com.alibaba.fastjson.serializer.SerializeWriter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class HelloWorld {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(" getString(\"").append("key").append("\").matches(\"").append("*.lls.*").append("\") ");
        System.out.println(sb.toString());

        System.out.println("key".matches(".*lls.*"));

    }
}
