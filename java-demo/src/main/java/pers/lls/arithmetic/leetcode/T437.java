package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;

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
    HashMap<Integer, Integer> qianzui = new HashMap<>();
    int pathSum = 0;
    Integer result = 0;

    public int pathSum(TreeNode root, int sum) {
        qianzui.put(0,1);
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        int val = root.val;
        pathSum+=val;
        result += qianzui.getOrDefault(pathSum-sum, 0);
        Integer orDefault = qianzui.getOrDefault(pathSum, 0);
        qianzui.put(pathSum, orDefault + 1);
        if (root.left!=null){
            dfs(root.left,sum);
        }
        if (root.right!=null){
            dfs(root.right,sum);
        }
        qianzui.put(pathSum, orDefault);
        pathSum-=val;
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

        int i = 22;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Integer[] treeIntarray = new Integer[]{
                5,4,8,11,null,13,4,7,2,null,null,5,1

        };

        TreeNode treeNode = new TreeNode().buildTree(treeIntarray);



        System.out.println(JSONObject.toJSONString(new T437().pathSum(treeNode,i), SerializerFeature.PrettyFormat));
    }
}