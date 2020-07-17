package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T26 {


    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right<nums.length)
        if (nums[left] == nums[right]){
            right++;
        }else {
            reverse(nums, left +1, right );
            left++;
            right++;
        }
        return left+1;
    }

    private void reverse(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[] intarray = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = 1 ;
        String string ="[";
        ListNode listNode = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));


        System.out.println(JSONObject.toJSONString(new T26().removeDuplicates(intarray)));
    }
}

