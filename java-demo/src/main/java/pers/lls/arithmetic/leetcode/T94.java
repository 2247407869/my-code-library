package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T94 {
    List<Integer> result = new ArrayList<>();
    public void recursion(TreeNode root) {
        if (root.left != null)
            recursion(root.left);
        result.add(root.val);
        if (root.right != null)
            recursion(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }




    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                2,3,4,0,0,0
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));



        System.out.println(JSONObject.toJSONString(new T94().inorderTraversal(new TreeNode().buildTree(new Integer[]{
                1,null,2,null,null,3})),
                SerializerFeature.PrettyFormat));
    }
}

