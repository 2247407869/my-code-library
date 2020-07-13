package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class T33 {

    public int search(int[] nums, int target) {
        if (nums.length==0)return -1;

        return findNumInAbnormalityList(0,nums.length-1,nums,target);
    }

    public int findNumInAbnormalityList(int l, int r, int[] nums, int target){
        if (l >= r) {if (nums[l] == target) return l; else return -1;}

        int mid = l + (r - l)/2;
        if (target == nums[mid]) return mid;
        // if left abnormal
        if (nums[mid] >= nums[l]){

            if (target >= nums[l] && target<= nums[mid]){
                return findNumInNormalList(l,mid,nums,target);
            } else {
                return findNumInAbnormalityList(mid+1,r,nums,target);
            }
        } else {
            if (target >= nums[mid] && target <= nums[r]){
                return findNumInNormalList(mid + 1, r,nums,target);
            } else {
                return findNumInAbnormalityList(l,mid,nums,target);
            }
        }
    }

    private int findNumInNormalList(int l, int r, int[] nums, int target) {
        if (l==r) {
            if (nums[l] == target){
                return l;
            }else{
                return -1;
            }
        }
        int mid = l + (r - l)/2;
        if (target == nums[mid])return  mid;
        if (target < nums[mid]){
            return findNumInNormalList(l,mid,nums,target);
        }else {
            return findNumInNormalList(mid+1,r,nums,target);
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

        System.out.println(JSONObject.toJSONString(new T33().search(new int[]{4,5,6,7,0,1,2}, 0)).equals("4"));
        System.out.println(JSONObject.toJSONString(new T33().search(new int[]{5,1,3}, 1)).equals("1"));
        System.out.println(JSONObject.toJSONString(new T33().search(new int[]{9,1,2,3,4,5,6,7,8}, 9)).equals("0"));
    }
}

