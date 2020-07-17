package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T43 {

    public String multiply(String num1, String num2) {
        if (num1 ==null || num2 == null || num1.equals("0") || num2.equals("0")) return "0";
        int length1 = num1.length();
        int length2 = num2.length();
        int[] result = new int[length1 + length2];
        for (int i = length1 -1 ; i >=0; i--) {
            for (int j = length2 - 1; j >=0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = temp + result[i + j+1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean start = false;
        for (int k = 0; k <length1 + length2; k++) {
            if (result[k] == 0 && !start) {
            }
            else {
                start = true;
                stringBuilder.append(result[k]);
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5, 1, 3
        };

        int i = 1;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T43().multiply("123", "0")));
    }
}

