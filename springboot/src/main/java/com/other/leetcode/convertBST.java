package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1417:49
 */
public class convertBST {

    static int count = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        root.val += count;
        count = root.val;
        convertBST(root.left);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(4);
        TreeNode treeNode = convertBST(root);

        System.out.println();
    }

}
