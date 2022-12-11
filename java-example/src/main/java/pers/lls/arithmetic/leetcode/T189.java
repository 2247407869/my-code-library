package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T189 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start <= end) {
            reverse(nums, start, end);
            start++;
            end--;
        }
    }

    private void reverse(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{

        };

        Integer[] integerarray = new Integer[]{
                -10, 9, 20, null, null, 15, 7
        };
        int[] intarray2 = new int[]{
                1, 2, 3
        };

        int i = 0;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray, i);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);

        new T189().rotate(intarray, i);


        System.out.println(JSONObject.toJSONString(intarray, SerializerFeature.PrettyFormat));
    }
}

