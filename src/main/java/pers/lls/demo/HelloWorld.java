package pers.lls.demo;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
public class HelloWorld {

    public final ArrayDeque<Integer> integers = new ArrayDeque<>();

    public static void main( String[] args ) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","lls");
        jsonObject.put("id",null);
        System.out.println(jsonObject.toString());

    }

}
