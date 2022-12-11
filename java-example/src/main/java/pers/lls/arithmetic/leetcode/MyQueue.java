package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayDeque;
import java.util.Deque;

// 用栈实现队列
public class MyQueue {
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.peekLast() == null){
            while (!stack1.isEmpty()){
                stack2.addLast(stack1.pollLast());
            }
        }
        return stack2.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.peekLast() == null){
            while (!stack1.isEmpty()){
                stack2.addLast(stack1.pollLast());
            }
        }
        return stack2.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack2.peekLast() == null){
            while (!stack1.isEmpty()){
                stack2.addLast(stack1.poll());
            }
        }
        return stack2.isEmpty();
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,1
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
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



        System.out.println(JSONObject.toJSONString(new MyQueue(), SerializerFeature.PrettyFormat));
    }
}

