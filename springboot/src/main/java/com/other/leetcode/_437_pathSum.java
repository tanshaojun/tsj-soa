package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 437. 路径总和 III
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1416:50
 */
public class _437_pathSum {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum1(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int pathSum1(TreeNode root, int sum, int count) {
        if (root == null) return 0;
        return (sum == count + root.val ? 1 : 0) +
                pathSum1(root.right, sum, count + root.val) +
                pathSum1(root.left, sum, count + root.val);
    }


    public static int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum3(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    public static int pathSum3(TreeNode root, int sum) {
        if (root == null) return 0;
        return (sum == root.val ? 1 : 0) +
                pathSum3(root.right, sum - root.val) +
                pathSum3(root.left, sum - root.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        System.out.println(pathSum(root, 8));
    }
}
