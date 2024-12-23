package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

// 快排 quick sort
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        int index;
        index = adjust(nums, 0, nums.length - 1, nums.length + 1 - k);
        return nums[index];
    }

    private int adjust(int[] nums, int l, int r, int k) {
        int leftend = l;
        // 最右边的数作为参照
        int end = nums[r];
        // 如果值小于参照，左边界与指针的值交换，左边界右移
        for (int i = l; i < r; i++) {
            if (nums[i] < end) {
                exchange(nums, i, leftend);
                leftend++;
            }
        }
        exchange(nums, r, leftend);

        int index = leftend;
        if (k - 1 > index) {
            return adjust(nums, index + 1, r, k);
        } else if (k - 1 < index) {
            return adjust(nums, l, index - 1, k);
        } else {
            return index;
        }
    }

    private void exchange(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

        int[] intarray = new int[]{
                3, 2, 1, 5, 6, 4
        };

        Integer[] integerarray = new Integer[]{
                -10, 9, 20, null, null, 15, 7
        };
        int[] intarray2 = new int[]{
                1, 2, 3
        };

        int i = 4;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray, -1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        System.out.println(JSONObject.toJSONString(new T215().findKthLargest(intarray, i), SerializerFeature.PrettyFormat));
    }
}

