package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T344 {
    public void reverseString(char[] s) {
        int left = 0,right = s.length - 1;
        while (left <= right){
            reverse(s, left, right);
            left++;
            right--;
        }
    }

    private void reverse(char[] s, int left, int right) {
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
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


        char[] charArray = new char[]{'h','e','l','l'};
        new T344().reverseString(charArray);
        System.out.println(charArray);
    }
}

