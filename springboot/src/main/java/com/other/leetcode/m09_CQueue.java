package com.other.leetcode;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/30 9:51
 */
public class m09_CQueue {

    private Stack<Integer> a = null;
    private Stack<Integer> b = null;

    public m09_CQueue() {
        this.a = new Stack<>();
        this.b = new Stack<>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (b.isEmpty()) {
            if (a.isEmpty()) return -1;
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

}
