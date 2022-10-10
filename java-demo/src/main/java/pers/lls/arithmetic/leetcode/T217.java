package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashSet;


public class T217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) return true;
            hashSet.add(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,1
        };

        Integer[] integerarray = new Integer[]{
                -10,9,20,null,null,15,7
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 2;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T217().containsDuplicate(intarray), SerializerFeature.PrettyFormat));
    }
}

