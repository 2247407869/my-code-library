package pers.lls.arithmetic.leetcode;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class T5185 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        int p0 = 0;
        int p1 = 1;
        int p2 = 2;
        for (int i = 2; i < arr.length; i++) {
            if (arr[p2]%2 != 0){
                if (arr[p1]%2 != 0){
                    if (arr[p0]%2 != 0){
                        return true;
                    }
                }
            }
            p0++;p1++;p2++;
        }
        return false;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,34,3,4,5,7,23,12
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 1;
        int i2 = 3;

        String string = "apple umai";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        char[] charArray = new char[]{'h','e','l','l'};
//        new T557().reverseWords(charArray);
//        System.out.println(charArray);
        System.out.println(JSONObject.toJSONString(new T5185().threeConsecutiveOdds(intarray), SerializerFeature.PrettyFormat));
    }
}

