package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"val","next"})
class ListNode {
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
}
