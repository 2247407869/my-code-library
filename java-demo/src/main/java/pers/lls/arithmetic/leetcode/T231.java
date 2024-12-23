package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T231 {
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (-n)) == n;
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



        System.out.println(JSONObject.toJSONString(new T231().isPowerOfTwo(i), SerializerFeature.PrettyFormat));
    }
}

