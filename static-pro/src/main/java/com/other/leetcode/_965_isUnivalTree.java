package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 965. 单值二叉树
 */
public class _965_isUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        int val = root.val;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val != val) {
                    return false;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return true;
    }
}
