package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 563. 二叉树的坡度
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/2 16:08
 */
public class _563_findTilt {

    int sum = 0;

    public int findTilt(TreeNode root) {
        tilt(root);
        return sum;
    }

    private int tilt(TreeNode root) {
        if (null == root) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

}
