package pers.lls.arithmetic.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小堆
 */
public class MinHeap {
    public int[] findMax10Num(int[] intarray, int k){
        for (int i = (k-1)/2; i >=0; i--) {
            adjust(intarray, i, k-1);
        }
        for (int i = k; i < intarray.length; i++) {
            if (intarray[i] > intarray[0]){
                intarray[0] = intarray[i];
                adjust(intarray, 0, k-1);
            }
        }
        return Arrays.copyOf(intarray, k);
    }

    private void adjust(int[] intarray, int start, int end) {
        int l = start * 2 + 1;
        int r = start * 2 + 2;
        int smallestp = start;
        if (l <= end && intarray[l] < intarray[smallestp]){
            smallestp = l;
        }
        if (r <= end && intarray[r] < intarray[smallestp]){
            smallestp = r;
        }
        if (smallestp == start){
            return;
        }
        swap(intarray, start, smallestp);
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
