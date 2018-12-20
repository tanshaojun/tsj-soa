package com.other.leetcode;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        Integer peek = min.peek();
        if (pop.equals(peek)) {
            min.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min.peek();
    }
}
