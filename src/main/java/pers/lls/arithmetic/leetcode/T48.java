package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class T48 {

    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length -j - 1] = temp;
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[][] intarrays = new int[][]{};

        int[] intarray = new int[]{
                1,2,3
        };

        int i = 1 ;

        String string ="123";

        String string2 = "456";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));


//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(1);
//        deque.add(2);
//        deque.();
//        System.out.println(deque);
        new T48().rotate(intarrays);
        System.out.println(JSONObject.toJSONString(intarrays));
    }
}

