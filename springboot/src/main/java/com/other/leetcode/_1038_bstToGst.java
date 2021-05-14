package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1038. 把二叉搜索树转换为累加树
 *
 * @Author tansj
 * @Date 2021-05-12 09:51
 * @Version 1.0
 */
public class _1038_bstToGst {

    int res = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        dfs(root.right);
        res += root.val;
        root.val = res;
        dfs(root.left);
    }

}
