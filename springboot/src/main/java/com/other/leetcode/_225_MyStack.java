package com.other.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 11:07
 */
public class _225_MyStack {


    Queue<Integer> q1 = null;

    Queue<Integer> q2 = null;

    /**
     * Initialize your data structure here.
     */
    public _225_MyStack() {
        q1 = new LinkedBlockingQueue<>();
        q2 = new LinkedBlockingQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        while (!empty()) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!empty())
            return q1.poll();
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!empty())
            return q1.peek();
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
