package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/3 16:18
 */
public class _701_insertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) return new TreeNode(val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                if (null == cur.left) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            }
            if (cur.val < val) {
                if (null == cur.right) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}
