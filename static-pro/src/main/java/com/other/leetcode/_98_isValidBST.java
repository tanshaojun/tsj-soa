package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树o
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/12 14:48
 */
public class _98_isValidBST {
    /**
     * 中序遍历判断
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        Stack<TreeNode> stack = new Stack<>();
        long min = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) return false;
            min = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
     * 递归
     *
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean f(TreeNode root, long minValue, long maxValue) {
        if (null == root) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return f(root.left, minValue, root.val) && f(root.right, root.val, maxValue);
    }

}
