package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * name tan shaojun
 * Date: 2019/6/15
 * Time: 1:15 PM
 */
public class _94_InorderTraversal {
    List<Integer> list1 = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list1.add(root.val);
            inorderTraversal(root.right);
        }
        return list1;

    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.add(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                list.add(head.val);
                head = head.right;
            }
        }
        return list;
    }
}
