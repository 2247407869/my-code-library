package pers.lls.arithmetic.leetcode;

import java.lang.reflect.InvocationTargetException;


public class T32 {
    // 先用动态规划做一下

    public int longestValidParentheses(String s) {
        if (s.equals("")) return 0;
        int[] dp = new int[s.length()];
        int result = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1 - dp[i-1];
            if (left < 0) dp[i] = 0;
            else {
                if (s.charAt(i) == ')' && s.charAt(left) == '('){
                    dp[i] = dp[i-1] + 2;
                    if (left - 1 >= 0)
                        dp[i] += dp [left - 1];
                }


                else dp[i] = 0;
            }
            result = Math.max(dp[i],result);
        }
        return result;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[] intarray = new int[]{3,2,1};
        int i = 1 ;
        String string =")()))(";
        ListNode listNode = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));

        new T32().longestValidParentheses(string);
//        System.out.println(JSONObject.toJSONString(intarray));
//        System.out.println(JSONObject.toJSONString(new T31().nextPermutation(intarray)));
    }
}

