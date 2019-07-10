package com.other.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class _232_MyQueue {
    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public _232_MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!b.isEmpty()) a.push(b.pop());
        a.push(x);
        while (!a.isEmpty()) b.push(a.pop());
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (b.isEmpty()) {
            return -1;
        }
        return b.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (b.isEmpty()) {
            return -1;
        }
        return b.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return b.isEmpty();
    }
}
