package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1008. 先序遍历构造二叉树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/3 16:40
 */
public class _1008_bstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode res = null;
        for (int i = 0; i < preorder.length; i++)
            res = addTreeNode(res, preorder[i]);
        return res;
    }

    private TreeNode addTreeNode(TreeNode root, int val) {
        if (null == root) return new TreeNode(val);
        if (root.val > val)
            root.left = addTreeNode(root.left, val);
        if (root.val < val)
            root.right = addTreeNode(root.right, val);
        return root;
    }
}
