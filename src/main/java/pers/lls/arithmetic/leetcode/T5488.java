package pers.lls.arithmetic.leetcode;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class T5488 {
    public int minDays(int n) {
        if (n<3)return n;
        short[] dp = new short[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            if (i%3==0 && i%2==0){
                dp[i] = (short) (Math.min(dp[i/3],Math.min(dp[i-1],dp[i/2]))+1);
            } else if (i%3==0){
                dp[i] = (short) (Math.min(dp[i/3],dp[i-1])+1);
            } else if (i%2==0){
                dp[i] = (short) (Math.min(dp[i/2],dp[i-1])+1);
            } else
                dp[i] = (short) (dp[i-1]+1);
        }
        return dp[n];
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
        System.out.println(JSONObject.toJSONString(new T5488().minDays(84806671), SerializerFeature.PrettyFormat));
    }
}

