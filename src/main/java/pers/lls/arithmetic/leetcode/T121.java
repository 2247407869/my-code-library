package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;


public class T121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }
        return result;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                3,2,1
        };

        Integer[] integerarray = new Integer[]{
                3,9,20,null,null,15,7
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T121().maxProfit(intarray), SerializerFeature.PrettyFormat));
    }
}

