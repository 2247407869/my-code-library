package pers.lls.arithmetic.leetcode;

import java.util.Arrays;

/**
 * 最小堆
 */
public class MinHeap {
    public int[] findMax10Num(int[] intarray, int k) {
        // i = (k - 1) / 2，取父节点
        for (int i = (k - 1) / 2; i >= 0; i--) {
            adjust(intarray, i, k - 1);
        }
        for (int i = k; i < intarray.length; i++) {
            if (intarray[i] > intarray[0]) {
                intarray[0] = intarray[i];
                adjust(intarray, 0, k - 1);
            }
        }
        return Arrays.copyOf(intarray, k);
    }

    // 保证每个子节点都比父节点小
    private void adjust(int[] intarray, int root, int end) {
        int l = root * 2 + 1;
        int r = root * 2 + 2;
        // 从父节点，左右节点找出最小的坐标
        int smallestp = root;
        if (l <= end && intarray[l] < intarray[smallestp]) {
            smallestp = l;
        }
        if (r <= end && intarray[r] < intarray[smallestp]) {
            smallestp = r;
        }
        // 如果最小的是父节点，不需要调整
        if (smallestp == root) {
            return;
        }
        // 将最小的节点与父节点交换
        swap(intarray, root, smallestp);

        adjust(intarray, smallestp, end);
    }

    private void swap(int[] intarray, int start, int smallestp) {
        int temp = intarray[start];
        intarray[start] = intarray[smallestp];
        intarray[smallestp] = temp;
    }

    public static void main(String[] args) {
        int[] max10Num = new MinHeap().findMax10Num(new int[]{1, 5, 3, 4, 2, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 5);
        for (Integer integer : max10Num) {
            System.out.println(integer);
        }
    }
}
