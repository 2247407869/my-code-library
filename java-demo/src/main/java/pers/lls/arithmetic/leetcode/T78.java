package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T78 {
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
//    public List<List<Integer>> subsets(int[] nums) {
//        int length = nums.length;
//        List<List<Integer>> result = new ArrayList<>();
//        backtrack(0,new ArrayList<>(),nums,length, result);
//        return result;
//    }

    public void backtrack(int start, List<Integer> path, int[] nums, int length,List<List<Integer>> result){

        for(int i = start; i <= length; i ++){
            if (i == length) {
                result.add(new ArrayList<>(path));
                return;
            }
            path.add(nums[i]);
            backtrack(i+1, path, nums, length, result);
            path.remove(path.size() - 1);
        }

    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T78().subsets(intarray), SerializerFeature.PrettyFormat));
    }
}

