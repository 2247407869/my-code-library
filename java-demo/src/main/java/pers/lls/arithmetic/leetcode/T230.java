package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayDeque;
import java.util.Deque;


public class T230 {
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> inorderArray = new ArrayList<>();
//        List<Integer> result = inorder(root, inorderArray);
//        return result.get(k-1);
//    }
//
//    private List<Integer> inorder(TreeNode root, List<Integer> inorderArray) {
//        if (root == null) {
//            return inorderArray;
//        }
//        inorder(root.left,inorderArray);
//        inorderArray.add(root.val);
//        inorder(root.right, inorderArray);
//        return inorderArray;
//    }
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true){
            while (root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            k--;
            if (k==0)
                return root.val;
            root = root.right;

        }
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

        int i = 2;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T230().kthSmallest(treeNode, i), SerializerFeature.PrettyFormat));
    }
}

