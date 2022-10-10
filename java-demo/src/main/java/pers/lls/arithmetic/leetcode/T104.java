package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;


public class T104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftdeep = maxDepth(root.left);
        int rightdeep = maxDepth(root.right);
        return Math.max(leftdeep, rightdeep)+1;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        Integer[] intarray = new Integer[]{
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

        TreeNode treeNode = new TreeNode().buildTree(intarray);



        System.out.println(JSONObject.toJSONString(new T104().maxDepth(treeNode), SerializerFeature.PrettyFormat));
    }
}

