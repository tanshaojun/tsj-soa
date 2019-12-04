package com.other.leetcode;

import com.other.model.ListNode;
import com.other.model.TreeNode;

/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/4 10:26
 */
public class _1261_FindElements {

    private TreeNode root;

    public _1261_FindElements(TreeNode root) {
        clear(root, 0);
        this.root = root;
    }

    private void clear(TreeNode root, int val) {
        if (null != root.left) {
            root.left.val = 2 * val + 1;
            clear(root.left, root.left.val);
        }
        if (null != root.right) {
            root.right.val = 2 * val + 2;
            clear(root.right, root.right.val);
        }
    }

    public boolean find(int target) {
        return dfs(root, target);
    }

    private boolean dfs(TreeNode root, int target) {
        if (root.val == target) return true;
        if (root.left != null && dfs(root.left, target)) return true;
        return root.right != null && dfs(root.right, target);
    }

}
