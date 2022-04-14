package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 2236. 判断根结点是否等于子结点之和
 *
 * @Author tansj
 * @Date 2022/4/12 10:30 上午
 * @Version 1.0
 */
public class _2236_checkTree {
    public boolean checkTree(TreeNode root) {
        if (null == root) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (null == left || null == right) {
            return false;
        }

        return left.val + right.val == root.val;
    }
}
