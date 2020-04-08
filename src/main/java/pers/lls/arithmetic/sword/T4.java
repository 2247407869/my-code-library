package pers.lls.arithmetic.sword;

import com.alibaba.fastjson.JSONObject;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class T4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {


        return build(in, 0, in.length - 1, pre, 0, pre.length - 1);
    }

    public TreeNode build(int[] in, int inl, int inr, int[] pre, int prel, int prer) {
        if (inl > inr || prel > prer) return null;
        TreeNode treeNode = null;
        for (int inc = inl; inc <= inr; inc++) {
            if (in[inc] == pre[prel]) {
                treeNode = new TreeNode(in[inc]);
                treeNode.left = build(in, inl, inc - 1, pre, prel + 1, prel + inc - inl);
                treeNode.right = build(in, inc + 1, inr, pre, prel + inc - inl + 1, prer);
                return treeNode;
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new T4().reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6})));
    }
}



