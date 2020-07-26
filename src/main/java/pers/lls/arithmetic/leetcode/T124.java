package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T124 {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        nodeGain(root);
        return maxPath;
    }

    public int nodeGain(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(0,nodeGain(root.left));
        int right = Math.max(0,nodeGain(root.right));
        maxPath = Math.max(maxPath, root.val + left + right);
        return root.val + Math.max(left, right);
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                7,1,5,3,6,4
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



        System.out.println(JSONObject.toJSONString(new T124().maxPathSum(treeNode), SerializerFeature.PrettyFormat));
    }
}

