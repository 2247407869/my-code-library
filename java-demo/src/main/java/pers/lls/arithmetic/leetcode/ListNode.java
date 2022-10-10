package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"val","next"})
class ListNode {
      private ListNode temp;

      public int getVal() {
            return val;
      }

      public void setVal(int val) {
            this.val = val;
      }

      public ListNode getNext() {
            return next;
      }

      public void setNext(ListNode next) {
            this.next = next;
      }

      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
            this.val = val;
      }

      ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
      }

      public ListNode buildListNode(int[] intarray){
            return build(intarray, 0, -1);
      }

      public ListNode buildListNode(int[] intarray, int pos){
            return build(intarray, 0, pos);
      }

      private ListNode build(int[] intarray, int i, int pos) {
            if (i == intarray.length){
                  if (pos >= 0) {
                        return temp;
                  }
                  return null;
            }
            ListNode listNode =  new ListNode(intarray[i]);
            if (i == pos) temp = listNode;
            listNode.next = build(intarray, ++i, pos);
            return listNode;
      }

      public static void main(String[] args) {
            ListNode object = new ListNode().buildListNode(new int[]{1, 2, 3}, 1);
            System.out.println(JSONObject.toJSONString(object));
      }
}
