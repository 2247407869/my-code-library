package pers.lls.arithmetic.leetcode;

import java.util.HashMap;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class T9 {
    public static void main(String[] args) {
        System.out.println(new T9().isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x<0||(x%10==0&&x!=0)) return false;
        int t = 0;
        while (t < x) {
            t = t*10 + x %10;
            x = x / 10;
        }
        return t == x || x == t/10;
    }
}
