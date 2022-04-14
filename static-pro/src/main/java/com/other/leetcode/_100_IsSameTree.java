package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 100. 相同的树
 */
public class _100_IsSameTree {
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(p);
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue1.add(q);
        while (!queue1.isEmpty()) {
            int size = queue.size();
            int size1 = queue1.size();
            if (size != size1) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode poll1 = queue1.poll();
                if (poll.val != poll1.val) {
                    return false;
                }
                if ((poll.left != null && poll1.left == null) || (poll.left == null && poll1.left != null) || (poll
                        .right != null && poll1.right == null) || (poll.right == null && poll1.right != null)) {
                    return false;
                }
                if (poll.left != null && poll1.left != null) {
                    queue.add(poll.left);
                    queue1.add(poll1.left);
                }
                if (poll.right != null && poll1.right != null) {
                    queue.add(poll.right);
                    queue1.add(poll1.right);
                }

            }
        }
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
