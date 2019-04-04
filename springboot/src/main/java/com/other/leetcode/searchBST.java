package com.other.leetcode;

public class searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) return root;
        if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        }
        return root;
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }
}
