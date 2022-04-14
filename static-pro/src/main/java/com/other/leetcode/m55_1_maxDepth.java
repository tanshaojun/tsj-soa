package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 17:04
 */
public class m55_1_maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
