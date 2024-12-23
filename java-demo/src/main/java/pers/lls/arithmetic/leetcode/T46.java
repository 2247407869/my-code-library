package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class T46 {

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length == 0) return result;

        boolean[] state = new boolean[length];
        Deque<Integer> path = new ArrayDeque<Integer>();

        dfs(nums, length, 0, state, path, result);

        return result;
    }

    private void dfs(int[] nums, int length, int i, boolean[] state, Deque<Integer> path, List<List<Integer>> result) {
        if (i == length)
            result.add(new ArrayList<>(path));
        else {
            for (int j = 0; j < length; j++) {
                if (state[j])
                    continue;
                path.add(nums[j]);
                state[j] = true;
                dfs(nums,length,i+1,state,path,result);
                path.removeLast();
                state[j] = false;
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


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

        System.out.println(JSONObject.toJSONString(new T46().permute(intarray)));
    }
}

