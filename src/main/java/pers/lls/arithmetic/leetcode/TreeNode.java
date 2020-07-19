package pers.lls.arithmetic.leetcode;


import com.alibaba.fastjson.JSONObject;

public class TreeNode {
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x) {val = x;}

    public TreeNode build(Integer[] intarray, int start){
        if (start >= intarray.length || intarray[start] == null) return null;
        TreeNode result = new TreeNode(intarray[start]);
        result.left = build(intarray,start * 2 + 1);
        result.right = build(intarray, start * 2 + 2);
        return result;
    }

    public TreeNode buildTree (Integer[] intarray) {
        return build(intarray, 0);
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new TreeNode().buildTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
