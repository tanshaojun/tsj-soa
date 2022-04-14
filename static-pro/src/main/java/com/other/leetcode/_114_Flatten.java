package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/2016:58
 */
public class _114_Flatten {

    public static void flatten(TreeNode root) {
        if (null == root) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = new TreeNode(0);
        TreeNode result = head;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            head.right = pop;
            head.left = null;
            head = head.right;
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        root = result.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);

        flatten(root);
    }
}
