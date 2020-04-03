package pers.lls.demo;

import com.alibaba.fastjson.serializer.SerializeWriter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.*;

/**
 *
 */
public class HelloWorld {

    private static final String TIME_ERROR_CONTENT = "%s已达到%s（最近%s分钟 %s）,%s阈值%s%s";
    private static final String TIME_OK_CONTENT = "%s已恢复到%s（最近%s分钟 %s）";
    private static final String COUNT_ERROR_CONTENT = "%s已达到%s（连续%s次）,%s阈值%s%s";
    private static final String COUNT_OK_CONTENT = "%s已恢复到%s（连续%s次）";
    private static final String DYNAMIC_ERROR_CONTENT = "%s已达到%s,连续%s次超过智能分析容忍范围";
    private static final String DYNAMIC_OK_CONTENT = "%s已恢复到%s，处于智能分析容忍范围内";
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {

        String smsdesc = DYNAMIC_ERROR_CONTENT;





        System.out.println(smsdesc);



    }
}
