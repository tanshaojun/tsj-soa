package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/5 15:09
 */
public class _222_countNodes {
    public int countNodes(TreeNode root) {
        if (null == root) return 0;
        //常规解法
        //if (null == root) return 0;
        //return countNodes(root.left) + countNodes(root.right) + 1;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) return (1 << left) + countNodes(root.right);
        return (1 << right) + countNodes(root.left);
    }

    private int getDepth(TreeNode root) {
        int level = 0;
        while (null != root) {
            level++;
            root = root.left;
        }
        return level;
    }
}
