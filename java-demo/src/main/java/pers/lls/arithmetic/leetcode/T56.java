package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;


public class T56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 ) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] result = new int[intervals.length][2];
        int[] array = new int[]{intervals[0][0],intervals[0][1]};
        result[0] = array;
        int pos = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > result[pos][1]){
                pos++;
                result[pos] = new int[]{intervals[i][0],intervals[i][1]};
            }else {
                if (intervals[i][1] > result[pos][1])
                    result[pos][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(result,++pos);
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                1,2
        };

        int[] intarray2 = new int[]{
                5,6
        };

        int[] intarray3 = new int[]{
                9,10
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

        System.out.println(JSONObject.toJSONString(new T56().merge(new int[][]{intarray})));
    }
}

