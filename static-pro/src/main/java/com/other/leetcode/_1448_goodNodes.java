package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 *
 * @Author tansj
 * @Date 2021-05-10 14:12
 * @Version 1.0
 */
public class _1448_goodNodes {

    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (null == root) {
            return;
        }
        int v = root.val;
        if (v >= max) {
            res++;
            max = Math.max(max, v);
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }

}
