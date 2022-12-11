package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode longOne = new ListNode();
        longOne.next = head;
        ListNode pre = head;
        for (int i = 0; i < n-1; i++) {
            pre = pre.next;
        }
        ListNode second = longOne;
        while (pre.next != null){
            pre = pre.next;
            second = second.next;
        }
        second.next = second.next.next;
        return longOne.next;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,4,5
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
                1,2,3
        };

        int i = 2;
        int i2 = 3;

        String string = "";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        char[] charArray = new char[]{'h','e','l','l'};
//        new T557().reverseWords(charArray);
//        System.out.println(charArray);
        System.out.println(JSONObject.toJSONString(new T19().removeNthFromEnd(listNode,2), SerializerFeature.PrettyFormat));
    }
}
