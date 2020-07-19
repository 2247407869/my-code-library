package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int high = matrix.length;
        int wide = matrix[0].length;

        int layer = (Math.min(high,wide)+1) / 2;

        List<Integer> result = new ArrayList<>();
        int top = 0, left = 0, right = wide -1, bottom = high -1;
        for (int i = 0; i < layer; i++) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            if (left != right && top != bottom){
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                for (int j = bottom - 1; j >= top + 1; j--) {
                    result.add(matrix[j][left]);
                }
            }

            top++;
            left++;
            right--;
            bottom--;
        }


        return result;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                1,2,3,4
        };

        int[] intarray2 = new int[]{
                5,6,7,8
        };

        int[] intarray3 = new int[]{
                9,10,11,12
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

        System.out.println(JSONObject.toJSONString(new T54().spiralOrder(new int[][]{intarray,intarray2,intarray3})));
    }
}

