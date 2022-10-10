package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashSet;


public class T1546 {

    public int maxNonOverlapping(int[] nums, int target) {
        int result = 0;
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target) || sum == target){
                sum = 0;
                set = new HashSet<>();
                result++;
            }else{
                set.add(sum);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                -1,3,5,1,4,2,-9
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 6;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T1546().maxNonOverlapping(intarray,i), SerializerFeature.PrettyFormat));
    }
}

