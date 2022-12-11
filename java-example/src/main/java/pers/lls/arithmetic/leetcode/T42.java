package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T42 {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int length = height.length;
        int[] leftHigh = new int[length];
        int[] rightHigh = new int[length];
        int result = 0;

        for (int i = 0; i < length; i++) {
            leftMax = Math.max(leftMax,height[i]);
            leftHigh[i] = leftMax;
        }
        for (int i = length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightHigh[i] = rightMax;
        }
        for (int i = 0; i < length; i++) {
            result += Math.min(leftHigh[i],rightHigh[i])-height[i];
        }
        return result;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5,1,3
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T42().trap(new int[]{})));
    }
}

