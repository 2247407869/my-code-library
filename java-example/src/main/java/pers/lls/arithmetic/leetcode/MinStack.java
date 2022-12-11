package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayDeque;
import java.util.Deque;


public class MinStack {
    Deque<MinNode> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        MinNode minNode = new MinNode();
        minNode.setValue(x);
        minNode.setMin(Math.min(getMin(),x));
        stack.push(minNode);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        assert stack.peek() != null;
        return stack.peek().getValue();
    }

    public int getMin() {
        if (stack.isEmpty()) return Integer.MAX_VALUE;
        assert stack.peek() != null;
        return stack.peek().getMin();
    }


    public static class MinNode{
        private int value;
        private int min;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                3,2,0,-4
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

        ListNode listNode = new ListNode().buildListNode(intarray,i);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);

        MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.push(-1);
        minStack.pop();

        System.out.println(JSONObject.toJSONString(minStack.top(), SerializerFeature.PrettyFormat));
    }
}

