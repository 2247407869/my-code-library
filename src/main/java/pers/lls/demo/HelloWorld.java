package pers.lls.demo;

import com.alibaba.fastjson.serializer.SerializeWriter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HelloWorld {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

// TODO Auto-generated method stub
        //获取所有变量的值
        Class clazz = Class.forName("pers.lls.demo.Alert");
        Field[] fields = clazz.getFields();
        StringBuilder sb = new StringBuilder();
        for( Field field : fields ){
            if (Modifier.isStatic(field.getModifiers())){

                sb.append(String.format("{\n" +
                        "                \"path\": \"%s\",\n" +
                        "                \"code\": \"%s\",\n" +
                        "                \"formats\": null,\n" +
                        "                \"dataType\": \"STRING\",\n" +
                        "                \"name\": \"%s\"\n" +
                        "            },",field.get(clazz),field.get(clazz),field.get(clazz)));
            }

        }
        System.out.println(sb.toString());
        //获取单个变量的值
        /*Class clazz = Class.forName("com.qianmingxs.ScoreTable");
        Field field = clazz.getField("FIVE");
        System.out.println( field.getInt(clazz));*/
    }
}
