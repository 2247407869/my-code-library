package pers.lls.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i>0&&nums[i] == nums[i-1]) continue;
            int k = length - 1;
            for (int j = i+1; j < length && k>j; ) {
                if (j>i+1&&nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (nums[j] + nums[k] > -nums[i]){
                    k--;
                }else if (nums[j] + nums[k] < -nums[i]){
                    j++;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(new T15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
