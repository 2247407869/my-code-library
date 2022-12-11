package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T53 {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                -2
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

        System.out.println(JSONObject.toJSONString(new T53().maxSubArray(intarray)));
    }
}

