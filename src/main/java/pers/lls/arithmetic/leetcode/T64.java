package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public class T64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j],dp[i][j-1]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[][] dubblearray = new int[][]{
                {1,3}
        };

        int[] intarray = new int[]{
                5, 1, 3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T64().minPathSum(dubblearray), SerializerFeature.PrettyFormat));
    }
}

