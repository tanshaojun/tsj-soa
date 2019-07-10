package com.other.leetcode;

/**
 * 112. 路径总和
 */
public class _112_HasPathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum - root.val == 0;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(8);
        r.right = new TreeNode(4);

        r.left.left = new TreeNode(11);
        r.left.left.left = new TreeNode(7);
        r.left.left.right = new TreeNode(2);

        r.right.left = new TreeNode(13);
        r.right.right = new TreeNode(4);
        r.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(r, 21));
    }
}
