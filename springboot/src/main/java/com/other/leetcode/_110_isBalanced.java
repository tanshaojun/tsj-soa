package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/17 9:35
 */
public class _110_isBalanced {

    public boolean isBalanced(TreeNode root) {
        return get(root) >= 0;
    }

    private int get(TreeNode root) {
        if (null == root) return 0;
        int r = get(root.right);
        int l = get(root.left);
        if (r < 0 || l < 0 || Math.abs(r - l) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

}
