package com.other.leetcode;

public class sumOfLeftLeaves {
    public static int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        return root.left == null ?
                (root.right == null ? 0 : sumOfLeftLeaves1(root.right)) :
                (root.left.left == null && root.left.right == null) ?
                        root.left.val + sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right) :
                        sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);

    }


    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        pre(root, false);
        return sum;
    }

    void pre(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        pre(root.left, true);
        pre(root.right, false);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(sumOfLeftLeaves1(root));
    }
}
