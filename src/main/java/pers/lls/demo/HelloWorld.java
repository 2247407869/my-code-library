package pers.lls.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.reverse(123));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/ 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (result < Integer.MIN_VALUE/ 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public int myAtoi(String str) {
        HashMap<String,String[]> statusMap = new HashMap<>();
        statusMap.put("start",new String[]{"start","sign","number","end"});
    }

    public int getCol(char c){
        if (c == ' ') return 0;
        else if (c == '+' || c == '-') return 1;
        else if (c >= '0' && c <= '9') return 2;
        else return 3;
    }
}
