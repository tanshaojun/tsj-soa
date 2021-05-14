package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * @Author tansj
 * @Date 2021-05-10 10:50
 * @Version 1.0
 */
public class _783_minDiffInBST {

    int min = Integer.MAX_VALUE;
    int front = -1;

    public int minDiffInBST(TreeNode root) {
        if (null != root) {
            minDiffInBST(root.left);
            if (front != -1) {
                min = Math.min(root.val - front, min);
            }
            front = root.val;
            minDiffInBST(root.right);
        }
        return min;
    }

}
