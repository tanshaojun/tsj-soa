package com.other.leetcode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @Author tansj
 * @Date 2021-05-12 13:39
 * @Version 1.0
 */
public class _117_connect {

    /**
     * 无额外空间
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = nextNode(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = nextNode(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node nextNode(Node root) {
        while (null != root) {
            if (root.left != null) {
                return root.left;
            }
            if (root.right != null) {
                return root.right;
            }
            root = root.next;
        }
        return null;
    }

    /**
     * 用了额外空间
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (null == root) {
            return root;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node target = queue.poll();
                if (pre == null) {
                    pre = target;
                } else {
                    pre.next = target;
                    pre = target;
                }
                if (target.left != null) {
                    queue.add(target.left);
                }
                if (target.right != null) {
                    queue.add(target.right);
                }
                pre.next = null;
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
