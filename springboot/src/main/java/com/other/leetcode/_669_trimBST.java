package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 669. 修剪二叉搜索树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 16:18
 */
public class _669_trimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (null == root) return null;
        if (root.val >= L && root.val <= R) {
            root.right = trimBST(root.right, L, R);
            root.left = trimBST(root.left, L, R);
        } else if (root.val > R) {
            root.right = null;
            return trimBST(root.left, L, R);
        } else {
            root.left = null;
            return trimBST(root.right, L, R);
        }
        return root;
    }
}
