package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/2 16:23
 */
public class _1022_sumRootToLeaf {

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num * 2 + root.val;
        if (root.left == null && root.right == null) {
            ans += num;
        } else {
            dfs(root.left, num);
            dfs(root.right, num);
        }
    }


}
