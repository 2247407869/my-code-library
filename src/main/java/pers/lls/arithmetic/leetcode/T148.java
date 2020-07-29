package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;


public class T148 {
    public ListNode sortList(ListNode head) {
        Integer length = 1;
        ListNode origin = head;
        int nodeLength = 0;
        while (origin!=null){
            origin = origin.next;
            nodeLength++;
        }
        origin = head;
        while (nodeLength>length){
            while(walk(origin,length)!=null){
                origin = merge(origin,length);
                origin = walk(origin,length*2);
            }
            length *=2;
        }

        return origin;
    }

    ListNode merge (ListNode origin, Integer length){
        ListNode result = new ListNode();
        ListNode pNode = result;
        int l1 = length, l2 = length;
        ListNode p1 = origin;
        ListNode p2 = walk(origin,length);
        ListNode next = walk(p2,length);
        while (l1 >0 &&l2>0){
            if (p1.val > p2.val){
                l2--;
                p2 = p2.next;
                pNode.next = p2;
            }else {
                l1--;
                p1 = p1.next;
                pNode.next = p1;
            }
            pNode = pNode.next;
        }
        while (l1 > 0){
            l1--;
            p1 = p1.next;
            pNode.next = p1;
            pNode = pNode.next;
        }
        while (l2 > 0){
            l2--;
            p2 = p2.next;
            pNode.next = p2;
            pNode = pNode.next;
        }
        pNode.next = next;
        return result.next;
    }

    ListNode walk (ListNode origin, Integer step){
        for (int i = 0; i < step; i++) {
            origin = origin.next;
            if(origin == null) return null;
        }
        return origin;
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                4,2,1,3
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

