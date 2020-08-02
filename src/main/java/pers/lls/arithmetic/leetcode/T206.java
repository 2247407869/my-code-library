package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
//    public ListNode reverseList(ListNode head) {
//        ListNode next;
//        ListNode p = head;
//        ListNode pre = null;
//        while (p != null){
//            next = p.next;
//            p.next = pre;
//            pre = p;
//            p = next;
//        }
//        return pre;
//    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,4,5
        };

        Integer[] integerarray = new Integer[]{
                -10,9,20,null,null,15,7
        };
        int[] intarray2 = new int[]{
            1,2,3
        };

        int i = 1;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T206().reverseList(listNode), SerializerFeature.PrettyFormat));
    }
}

