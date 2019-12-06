package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 129. 求根到叶子节点数字之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 17:24
 */
public class _129_sumNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        int val = 0;
        dfs(root, val);
        return sum;
    }

    private void dfs(TreeNode root, Integer val) {
        if (null == root) return;
        int tmp = val * 10 + root.val;
        if (null == root.left && null == root.right) sum += tmp;
        dfs(root.left, tmp);
        dfs(root.right, tmp);
    }

}
