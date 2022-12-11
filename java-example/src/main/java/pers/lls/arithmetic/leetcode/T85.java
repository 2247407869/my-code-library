package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class T85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] dp = new int[matrix[0].length];
        int result = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                dp[i] = chars[i] == '1' ? dp[i]+1 : 0;
            }
            result = Math.max(result, largestRectangleArea(dp));
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right,length-1);
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while ( !stack.isEmpty() && heights[stack.peekLast()] > heights[i]){
                right[stack.peekLast()] = i - 1;
                stack.pollLast();
            }

            int peek = stack.isEmpty()?-1:stack.peek();
            int peekhigh = peek == -1?0:heights[peek];

            if (heights[i] >= peekhigh){
                left[i] = stack.isEmpty()? 0 : stack.peekLast() + 1;
                stack.add(i);

            }

        }

        for (int i = 0; i < length; i++) {
            max = Math.max(max,heights[i] * (right[i] - left[i] + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new T85().maximalRectangle(new char[][]{{'0','1','1'},{'0','1',
                '1'}})));
    }
}