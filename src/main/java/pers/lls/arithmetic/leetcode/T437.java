package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class T437 {
    public int pathSum(TreeNode root, int sum) {
        return 0;
    }

    public static void main(String[] args) {


        Integer[] intarray = new Integer[]{
                5,
                4,8,
                11,null,13,4,
                7,2,null,null,null,null,5,1
        };
        int[] intarray2 = new int[]{
                1,2,3
        };

        int i = 8;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Integer[] treeIntarray = new Integer[]{
                10,5,-3,3,2,null,11,3,-2,null,1
        };

        TreeNode treeNode = new TreeNode().buildTree(treeIntarray);



        System.out.println(JSONObject.toJSONString(new T437().pathSum(treeNode,i), SerializerFeature.PrettyFormat));
    }
}