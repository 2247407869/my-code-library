package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T31 {


    public void nextPermutation(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int i = nums.length-1;
        for ( ; i >=0; i--) {
            if (nums[i]<pre) break;
            pre = nums[i];
        }
        if (i == -1) reverse(nums,0,nums.length-1);
        else {
            int j = nums.length-1;
            for ( ; j >=0; j--) {
                if (nums[j]>nums[i]) break;
            }
            exchange(nums,i,j);
            reverse(nums,++i,nums.length-1);
        }

    }

    private void exchange(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int[] nums, int left, int right){
        while (left<right){
            exchange(nums,left,right);
            left++;right--;
        }
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[] intarray = new int[]{3,2,1};
        int i = 1 ;
        String string ="[";
        ListNode listNode = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));

        new T31().nextPermutation(intarray);
        System.out.println(JSONObject.toJSONString(intarray));
//        System.out.println(JSONObject.toJSONString(new T31().nextPermutation(intarray)));
    }
}

