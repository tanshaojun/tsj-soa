package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 226. 翻转二叉树
 */
public class _226_InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;

    }

    public static void main(String[] args) {

    }
}
