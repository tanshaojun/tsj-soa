package com.other.leetcode;

/**
 * 543. 二叉树的直径
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1418:36
 */
public class _543_DiameterOfBinaryTree {
    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        len(root);
        return max;
    }

    private static int len(TreeNode right) {
        if (null == right) return 0;
        int l = len(right.left);
        int r = len(right.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }
}
