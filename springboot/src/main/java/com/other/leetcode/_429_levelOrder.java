package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 429. N叉树的层序遍历
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/4 11:27
 */
public class _429_levelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (null == root) return lists;
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                for (Node child : poll.children)
                    queue.add(child);
            }
            lists.add(list);
        }
        return lists;
        
    }

    class Node {
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
