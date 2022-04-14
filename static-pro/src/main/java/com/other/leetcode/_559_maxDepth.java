package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 17:01
 */
public class _559_maxDepth {
    public static void main(String[] args) {
        Node node = new Node();
        List<Node> _children = new ArrayList<>();
        Node node0 = new Node(0, null);
        Node node1 = new Node(0, null);
        Node node2 = new Node(0, null);
        Node node3 = new Node(0, null);
        _children.add(node0);
        _children.add(node1);
        _children.add(node2);
        _children.add(node3);
        node.children = _children;
        System.out.println(maxDepth(node));
    }

    public static int maxDepth(Node root) {
        if (null == root) return 0;
        List<Node> children = root.children;
        if (children == null) return 1;
        int max = 1;
        for (Node child : children) {
//            int len = maxDepth(child) + 1;
//            if (max < len) {
//                max = len;
//            }
            max = Math.max(max, maxDepth(child) + 1);
        }
        return max;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
