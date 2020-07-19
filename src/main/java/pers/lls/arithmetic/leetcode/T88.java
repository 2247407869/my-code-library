package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public class T88 {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p1 = m-1;
//        int p2 = n-1;
//        int p3 = nums1.length-1;
//        while (p1>=0&&p2>=0){
//            if (nums1[p1] > nums2[p2]){
//                nums1[p3] = nums1[p1];
//                p1--;
//            } else {
//                nums1[p3] = nums2[p2];
//                p2--;
//            }
//            p3--;
//        }
//        if (p1<0){
//            while (p2>=0){
//                nums1[p3] = nums2[p2];
//                p2--;
//                p3--;
//            }
//        } else {
//            while (p1>=0){
//                nums1[p3] = nums1[p1];
//                p1--;
//                p3--;
//            }
//        }
//        System.arraycopy(nums2,0,nums1,0,p2+1);
//
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                2,3,4,0,0,0
        };
        int[] intarray2 = new int[]{
1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        new T88().merge(intarray,i,intarray2,i2);

        System.out.println(JSONObject.toJSONString(intarray, SerializerFeature.PrettyFormat));
    }
}

