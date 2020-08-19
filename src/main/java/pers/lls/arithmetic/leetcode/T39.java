package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class T39 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrace(new ArrayList<>(),target, candidates,0);
        return result;
    }

    private void backtrace(ArrayList<Integer> integers, int target, int[] candidates, int now) {
        if (target == 0) result.add(new ArrayList<>(integers));
        else if (target < 0);
        else {
            for (int i = now; i < candidates.length; i++) {
                integers.add(candidates[i]);
                backtrace(integers,target-candidates[i],candidates, i);
                integers.remove(integers.size()-1);
            }
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5,1,3
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T39().combinationSum(new int[]{2,3,6,7}, 7)));
    }
}

