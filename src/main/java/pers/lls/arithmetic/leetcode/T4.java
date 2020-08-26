package pers.lls.arithmetic.leetcode;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/*给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

        请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

        你可以假设 nums1 和 nums2 不会同时为空。

         

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] snums = size1 > size2 ? nums2 :nums1;
        int[] lnums = size1 > size2 ? nums1 :nums2;

        int totalleft = (size1 + size2 + 1) / 2;

        int left = 0;
        int right = snums.length;
        // 二分法，求的是分割线的最小值
        while (left < right){
            int mid = left + (right - left)/2;
            if ((mid==0?Integer.MIN_VALUE:snums[mid - 1]) > ((totalleft-mid) == lnums.length?Integer.MAX_VALUE:lnums[totalleft - mid])){
                // 左边的数永远小于右边的数，如果左上角的数大于右下角的数，说明分割线在左半边
                right = mid;
            } else {

                // 如果左上角数小于右下角数，分割线在右半边
                left = mid+1;
            }
        }

        int numupleft = left ==0?Integer.MIN_VALUE:snums[left-1];
        int numupright = left == snums.length?Integer.MAX_VALUE:snums[left];
        int numdownleft = totalleft - left == 0?Integer.MIN_VALUE:lnums[totalleft - left -1 ];
        int numdownright = totalleft - left ==lnums.length?Integer.MAX_VALUE:lnums[totalleft - left];

        if ((size1 + size2)%2==0){
            return (Math.max(numupleft,numdownleft)+Math.min(numupright,numdownright))/2.0;
        }else{
            return Math.max(numupleft,numdownleft);
        }
    }

    public static void main(String[] args) {

        int[] intarray = new int[]{
                3
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
                -2,-1
        };

        int i = 2;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T4().findMedianSortedArrays(intarray, intarray2), SerializerFeature.PrettyFormat));
    }
}

