package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
public class _700_SearchBST {
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
