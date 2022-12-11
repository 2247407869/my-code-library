package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

/**
 *
 */
public class QuickSort {

    public int[] sort(int [] nums){
        return sort(nums, 0, nums.length-1);
    }

    public int[] sort(int[] nums, int start, int end){
        if (start >= end) return nums;
        int l = start;
        int r = end;
        int base = nums[l];
        while (l != r){
            if (nums[r] > base && r > l){
                r--;
                continue;
            }
            if (nums[l] <= base && l < r){
                l++;
                continue;
            }

            exchange(nums, l, r);
        }
        exchange(nums, start, l);
        sort(nums, start, l - 1);
        sort(nums, l+1 , end);
        return nums;
    }

    private void exchange(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main( String[] args ) {
        System.out.println(JSONObject.toJSONString(new QuickSort().sort(new int[]{1, 5, 3, 7, 2, 0, 9, 1, 1, 0})));

    }

}
