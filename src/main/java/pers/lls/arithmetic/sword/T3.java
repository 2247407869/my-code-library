package pers.lls.arithmetic.sword;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class T3 {
    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;
        if (listNode.next!=null){
            arrayList = printListFromTailToHead(listNode.next);
        }
        arrayList.add(listNode.val);
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next = listNode3;
        System.out.println(new T3().printListFromTailToHead(listNode1));

    }

}
