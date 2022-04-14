package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class _104_MaxDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

    }
}
