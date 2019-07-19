package com.other.leetcode;

import java.util.Stack;

/**
 * 430. 扁平化多级双向链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/18 20:07
 */
public class _430_Flatten {
    public Node1 flatten(Node1 head) {
        if (head == null) return head;
        Stack<Node1> stack = new Stack<>();
        Node1 cur = head;
        Node1 tmp;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                    cur.next = null;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            if (cur.next == null && !stack.isEmpty()) {
                tmp = stack.pop();
                cur.next = tmp;
                tmp.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;

    public Node1() {
    }

    public Node1(int _val, Node1 _prev, Node1 _next, Node1 _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
