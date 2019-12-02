package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 814. 二叉树剪枝
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 15:20
 */
public class _814_pruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (null == root) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (null == root.left && null == root.right && 0 == root.val) {
            return null;
        }
        return root;
    }
}
