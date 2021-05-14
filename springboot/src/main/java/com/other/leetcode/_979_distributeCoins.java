package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 979. 在二叉树中分配硬币
 *
 * @Author tansj
 * @Date 2021-05-10 14:27
 * @Version 1.0
 */
public class _979_distributeCoins {

    int res = 0;

    int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int count = left + right + root.val - 1;
        res += Math.abs(count);
        return count;
    }

}
