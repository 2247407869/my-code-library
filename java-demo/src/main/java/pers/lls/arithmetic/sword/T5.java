package pers.lls.arithmetic.sword;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class T5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.add(stack1.pop());
            }
        }

        if (stack2.empty()) return 0;
        return stack2.pop();
    }

    public static void main(String[] args) {
        T5 t5 = new T5();
        t5.push(1);
        t5.pop();
        t5.pop();
    }
}
