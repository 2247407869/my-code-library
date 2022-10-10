package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T148 {
    public ListNode sortList(ListNode head) {
        int length = 1;
        ListNode origin = head;
        int nodeLength = 0;
        while (origin!=null){
            origin = origin.next;
            nodeLength++;
        }

        ListNode pre = new ListNode();
        ListNode res = pre;
        ListNode h = head;
        res.next = head;
        while (nodeLength > length) {
            ListNode p1, p2;

            while (h != null){
                p1 = h;
                int i = length;
                for (; i > 0 && h!=null; i--) {
                    h = h.next;
                }
                if (i>0) {
                    continue;
                }
                p2 = h;
                i = length;
                for (; i > 0 && h != null ; i--) {
                    h = h.next;
                }
                int l1 = length, l2 = length - i;
                while (l1 > 0 && l2 > 0) {
                    if (p1.val > p2.val) {
                        l2--;
                        res.next = p2;
                        p2 = p2.next;
                    } else {
                        l1--;
                        res.next = p1;
                        p1 = p1.next;
                    }
                    res = res.next;
                }
                while (l1 > 0) {
                    l1--;

                    res.next = p1;
                    p1 = p1.next;
                    res = res.next;
                }
                while (l2 > 0) {
                    l2--;
                    res.next = p2;
                    p2 = p2.next;
                    res = res.next;
                }
                res.next = h;
            }
            length *= 2;
            h = pre.next;
            res = pre;
        }

        return pre.next;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1
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



        System.out.println(JSONObject.toJSONString(new T148().sortList(listNode), SerializerFeature.PrettyFormat));
    }
}

