package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T236 {

    static TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasTarget(root,p,q);
        return ans;
    }

    public boolean hasTarget(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        boolean left = hasTarget(root.left, p, q);
        boolean right = hasTarget(root.right, p, q);
        if ((left && right) || (left || right) && (root == p || root == q)){
            ans = root;
            return true;
        } else return left || right || root == p || root == q;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,1
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 1;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T236().lowestCommonAncestor(null,treeNode,treeNode), SerializerFeature.PrettyFormat));
    }
}

