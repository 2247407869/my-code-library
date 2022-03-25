package pers.lls.java;

import org.apache.commons.lang3.StringUtils;

public class StringDemo {
    public static void main(String[] args) {
        String str = null;
        Object a = str;
        String b = (String) a;
//        String b2 = a.toString();
        String b3 = String.valueOf(a);
        System.out.println(b + "123");
        System.out.println(b + "123");
//        System.out.println(b2);
        System.out.println(b3 + "123");
        System.out.println(StringUtils.isNotEmpty(b));
    }
}
