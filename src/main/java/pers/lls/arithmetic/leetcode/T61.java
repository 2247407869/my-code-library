package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;


public class T61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head;
        int length = 1;
        for ( ; p.next!=null ; length++){
            p = p.next;
        }
        if (k % length == 0) return head;
        p = head;
        for (int i = 0; i < k%length; i++) {
            p = p.next;
        }
        ListNode p2 = head;
        while (p.next!=null){
            p = p.next;
            p2 = p2.next;
        }
        ListNode result = p2.next;
        p2.next = null;
        p.next = head;
        return result;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
                5, 1, 3
        };

        int i = 1;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(JSONObject.toJSONString(new T61().rotateRight(listNode, 3), SerializerFeature.PrettyFormat));
    }
}

