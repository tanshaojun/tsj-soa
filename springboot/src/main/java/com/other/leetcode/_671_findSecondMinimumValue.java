package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * @Author tansj
 * @Date 2021-05-10 13:18
 * @Version 1.0
 */
public class _671_findSecondMinimumValue {

    int min = Integer.MAX_VALUE;

    boolean f = false;

    public int findSecondMinimumValue(TreeNode root) {

        if (null == root) {
            return -1;
        }

        dfs(root, root.val);
        if (!f) {
            return -1;
        }

        if (min == root.val) {
            return -1;
        }

        return min;
    }

    private void dfs(TreeNode root, int val) {
        if (null == root) {
            return;
        }
        dfs(root.left, val);
        int v = root.val;
        if (val != v) {
            f = true;
            min = Math.min(v, min);
        }
        dfs(root.right, val);
    }

}
