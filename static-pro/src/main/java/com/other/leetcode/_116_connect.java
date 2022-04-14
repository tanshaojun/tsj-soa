package com.other.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class _116_connect {

    public Node connect(Node root) {
        if (null == root) return root;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                Node left = poll.left;
                if (pre != null) {
                    pre.next = left;
                }
                Node right = poll.right;
                if (left != null) {
                    queue.add(left);
                    left.next = right;
                    pre = right;
                }
                if (right != null) {
                    queue.add(right);
                }
            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}