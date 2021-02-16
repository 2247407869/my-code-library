package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

// 堆排序，有点不对，adjust方法可以抽一个for循环出去
public class T215_2 {

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        adjust(heap, k);
        for (int i = k; i < nums.length; i++) {
            put(nums[i], heap, k);
        }
        return peek(heap);
    }

    private int peek(int[] heap) {
        return heap[0];
    }

    private void put(int num, int[] heap, int k) {
        if (num > peek(heap)) {
            heap[0] = num;
            adjust(heap, k);
        }
    }

    private void adjust(int[] heap, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--) {

            for (int minPos = i; ; i = minPos) {
                int left = i * 2 + 1;
                int right = left + 1;
                if (left < k && heap[left] < heap[i]) {
                    exchange(heap, left, i);
                    minPos = left;
                }
                if (right < k && heap[right] < heap[i]) {
                    exchange(heap, right, i);
                    minPos = right;
                }
                if (minPos == i) break;
            }
        }
    }

    private void exchange(int[] heap, int i, int j) {
        heap[i] ^= heap[j];
        heap[j] ^= heap[i];
        heap[i] ^= heap[j];
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

        int i = 2;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray, -1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        System.out.println(JSONObject.toJSONString(new T215_2().findKthLargest(intarray, i), SerializerFeature.PrettyFormat));
    }
}

