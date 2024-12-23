package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T169 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int start, int end) {
        if (start == end){
            return nums[start];
        }
        int mid = start + (end - start) /2;
        int left = majorityElementRec(nums,start,mid);
        int right = majorityElementRec(nums,mid + 1, end);
        if (left == right) return left;
        else {
            int leftcount = count(nums, left, start, end);
            int rightcount = count(nums, right, start, end);
            return leftcount > rightcount ? left : right;
        }
    }

    private int count(int[] nums, int left, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == left) count++;
        }
        return count;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                2,2,1,1,1,2,2
        };

        Integer[] integerarray = new Integer[]{
                -10,9,20,null,null,15,7
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 1;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,i);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T169().majorityElement(intarray), SerializerFeature.PrettyFormat));
    }
}

