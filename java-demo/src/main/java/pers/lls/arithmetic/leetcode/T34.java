package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T34 {
    int ll;
    int rr;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        findleft(nums,target,0,nums.length-1);
        findright(nums,target,0,nums.length-1);
        if (ll > rr) return new int[]{-1,-1};
        return new int[]{ll,rr};
    }

    private void findright(int[] nums, int target, int l, int r) {
        while (l < r){
            int mid = l + (r - l + 1) / 2;

            // 中间值偏大时，右边界可以收到mid-1
            if (nums[mid] > target){
                r = mid - 1;
            }
            // 中间值偏小或者等于时，左边界收到mid，mid要留到下一回合
            else {
                l = mid;
            }
        }
        if (nums[l] == target)
            rr = l;
        else rr = -1;
    }

    private void findleft(int[] nums, int target, int l, int r) {
        while (l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if (nums[l] == target)
            ll = l;
        else ll = -1;

    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5,1,3
        };

        int i = 1 ;

        String string ="[";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T34().searchRange(new int[]{}, 4)));
    }
}

