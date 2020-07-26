package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,1,2,2,3
        };

        Integer[] integerarray = new Integer[]{
                -10,9,20,null,null,15,7
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



        System.out.println(JSONObject.toJSONString(new T136().singleNumber(intarray), SerializerFeature.PrettyFormat));
    }
}

