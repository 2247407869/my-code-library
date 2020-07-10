package pers.lls.arithmetic.leetcode;

public class T11 {
    public static void main(String[] args) {
        System.out.println(new T11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int lengh = height.length;
        int result = 0;
        int left = 0;
        int right = lengh - 1;
        while (left != right){
            int v ;

            if (height[left]> height[right]) {
                v = (right - left) * height[right];
                right--;
            }

            else {
                v = (right - left) * height[left];
                left++;
            }

            result = Math.max(v,result);
        }
        return result;
    }
}
