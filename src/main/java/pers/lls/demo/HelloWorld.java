package pers.lls.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
public class HelloWorld {

    public static void main( String[] args ) {
        String str = "皇岗海关\t5301\t福田区\n" +
                "深圳宝安机场海关\t5317\t宝安区\n" +
                "深圳湾海关\t5345\t南山区\n" +
                "罗湖海关\t5302\t罗湖区\n" +
                "文锦渡海关\t5320\t罗湖区\n" +
                "沙头角海关\t5303\t盐田区\n" +
                "蛇口海关\t5304\t南山区\n" +
                "大鹏海关\t5316\t盐田区\n" +
                "大铲湾海关\t5348\t宝安区\n" +
                "三门岛海关\t5331\t惠州市大亚湾区\n" +
                "西九龙站海关\t5353\t香港西九龙高铁站\n" +
                "深圳邮局海关\t5314\t宝安区\n" +
                "梅林海关\t5318\t龙华区\n" +
                "福强海关\t5305\t福田区\n" +
                "沙湾海关\t5340\t福田区\n" +
                "南头海关\t5307\t宝安区\n" +
                "福中海关\t5355\t福田区\n" +
                "前海海关\t5356\t南山区\n" +
                "同乐海关\t5319\t宝安区\n" +
                "布吉海关\t5309\t龙岗区\n" +
                "笋岗海关\t5306\t罗湖区\n" +
                "福田海关\t5321\t福田区\n" +
                "梅沙海关\t5352\t盐田区\n" +
                "观澜海关\t5357\t龙华区\n" +
                "西沥海关\t5358\t光明区\n" +
                "龙岗海关\t5308\t龙岗区\n" +
                "坪山海关\t5339\t坪山区\n" +
                "惠州海关\t5341\t惠州海关\n" +
                "惠州港海关\t5338\t惠州市惠阳区\n" +
                "惠东海关\t5315\t惠州市惠东县";
        var strs = str.split("\n");
        for (String s : strs) {
            String[] split = s.split("\t");
            System.out.println("WHEN IEPORT = '"+split[1]+"' THEN '"+split[2]+"'");
        }

    }

}
