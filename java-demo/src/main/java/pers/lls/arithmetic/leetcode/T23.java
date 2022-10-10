package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;


public class T23 {


    public ListNode mergeKLists(ListNode[] lists) {

        int left = 0;
        int length = lists.length;
        if (length == 0) return null;
        int right = length - 1;
        return merge(lists, left, right);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l = merge(lists, left, mid);
        ListNode r = merge(lists, mid + 1, right);
        return mergeTwoLists(l,r);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode();
        ListNode pr = result;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                pr.next = p2;
                p2 = p2.next;
            } else {
                pr.next = p1;
                p1 = p1.next;
            }
            pr = pr.next;
        }

        if (p1 == null){
            pr.next = p2;
        } else {
            pr.next = p1;
        }

        return result.next;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[] intarray = new int[]{-1,2,1,-4};
        int i = 1 ;
        String string ="[";
        ListNode listNode = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3 = new ListNode(2,new ListNode(6));


        System.out.println(JSONObject.toJSONString(new T23().mergeKLists(new ListNode[]{listNode,null,listNode2,listNode3})));
    }
}

