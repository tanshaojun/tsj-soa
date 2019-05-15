package com.other.leetcode;

import java.util.Stack;

public class rangeSumBST {

    public static int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        boolean b = false;
        Stack<TreeNode> stack = new Stack();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.add(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                if (L == head.val) b = true;
                if (b) sum += head.val;
                if (R == head.val) b = false;
                head = head.right;
            }
        }
        return sum;
    }

    /**
     * 中序
     *
     * @param root
     */
    public static void middleOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.add(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    /**
     * 前序
     *
     * @param root
     * @return
     */
    public static void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        stack.add(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null)
                stack.push(pop.right);
            if (pop.left != null)
                stack.push(pop.left);
        }
    }

    /**
     * 后序
     *
     * @param root
     * @return
     */
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tmp = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            tmp.push(root);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }
        while (!tmp.isEmpty()) {
            System.out.print(tmp.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(null, 7, 15));
    }

}
