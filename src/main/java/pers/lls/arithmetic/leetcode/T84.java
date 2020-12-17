package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class T84 {
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

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                1
        };

        int i = 3;
        int i2 = 3;

        String string = "abdc";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        char[][] chararray = new char[][]{
                {'a','b'},
                {'c','d'}};
        System.out.println(JSONObject.toJSONString(new T84().largestRectangleArea(intarray), SerializerFeature.PrettyFormat));
    }
}

