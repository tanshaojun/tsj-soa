package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 226. 翻转二叉树
 */
public class _226_InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }
}
