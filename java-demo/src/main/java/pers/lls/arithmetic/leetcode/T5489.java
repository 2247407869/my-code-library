package pers.lls.arithmetic.leetcode;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Arrays;

public class T5489 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int lo = 1;
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(position, mid, m)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        return ans;
    }

    boolean check(int[] position, int distance, int m) {
        int count = 1;
        int i = 0;
        for (int j = 1; j < position.length; j++) {
            if (position[j] - position[i] >= distance) {
                i = j;
                count++;
                if (count >= m) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,4,7
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "apple umai";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        char[] charArray = new char[]{'h','e','l','l'};
//        new T557().reverseWords(charArray);
//        System.out.println(charArray);
        System.out.println(JSONObject.toJSONString(new T5489().maxDistance(intarray,i), SerializerFeature.PrettyFormat));
    }
}

