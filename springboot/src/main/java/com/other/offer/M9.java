package com.other.offer;

import java.util.Stack;

public class M9 {

    /**
     * 两个栈实现一个队列
     * 让添加的元素进入输入栈，弹出的时候先把输入栈里面的元素加入输出栈，然后从输出栈里面弹出元素。
     */
    public class Queue {

        private Stack<Integer> input = null;
        private Stack<Integer> output = null;

        public Queue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void add(int val) {
            input.add(val);
        }

        public int pop() {
            if (!output.isEmpty())
                return output.pop();

            while (!input.isEmpty())
                output.add(input.pop());

            if (!output.isEmpty())
                return output.pop();

            return -1;
        }

    }

}
