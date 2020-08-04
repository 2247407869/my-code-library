package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)return null;
        ListNode p1 = headA,p2 = headB;
        while (p1!=p2){
            p1 = p1 == null ? headB :p1.next;
            p2 = p2 == null ? headA :p2.next;
        }
        return p1;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2
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

        ListNode listNode3 = new ListNode(9);

        ListNode listNode = new ListNode(1,new ListNode(2,listNode3));

        ListNode listNode2 = new ListNode(1, listNode3);



        TreeNode treeNode = new TreeNode().buildTree(integerarray);



        System.out.println(JSONObject.toJSONString(new T160().getIntersectionNode(listNode,listNode2), SerializerFeature.PrettyFormat));
    }
}

