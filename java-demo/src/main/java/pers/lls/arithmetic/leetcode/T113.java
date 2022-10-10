package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 路径总和 2
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class T113 {
    List<List<Integer>> paths = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return paths;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root==null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum){
            paths.add(new ArrayList<>(path));
        }else {
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
        }
        path.removeLast();
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
                5,
                4,8,
                11,null,13,4,
                7,2,null,null,null,null,5,1
        };

        TreeNode treeNode = new TreeNode().buildTree(treeIntarray);



        System.out.println(JSONObject.toJSONString(new T113().pathSum(treeNode,i), SerializerFeature.PrettyFormat));
    }
}

