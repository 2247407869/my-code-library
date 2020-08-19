package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T42 {
    public int trap(int[] height) {
        return 0;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5,1,3
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T42().trap(new int[]{7,2,3,6,7})));
    }
}

