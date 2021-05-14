package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1325. 删除给定值的叶子节点
 *
 * @Author tansj
 * @Date 2021-05-10 13:54
 * @Version 1.0
 */
public class _1325_removeLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    private boolean dfs(TreeNode root, int target) {
        if (null == root) {
            return false;
        }
        boolean left = dfs(root.left, target);
        if (left) {
            root.left = null;
        }
        boolean right = dfs(root.right, target);
        if (right) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == target) {
            return true;
        }
        return false;
    }

}
