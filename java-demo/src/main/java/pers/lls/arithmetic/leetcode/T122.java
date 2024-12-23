package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int last = prices[0];
        for (int price : prices) {
            if (price > last)
                result = result + price - last;
            last = price;
        }
        return result;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                7,1,5,3,6,4
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



        System.out.println(JSONObject.toJSONString(new T122().maxProfit(intarray), SerializerFeature.PrettyFormat));
    }
}

