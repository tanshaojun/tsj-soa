package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 897. 递增顺序搜索树
 *
 * @Author tansj
 * @Date 2021-05-06 10:23
 * @Version 1.0
 */
public class _897_increasingBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                head = pop.right;
            }
        }
        TreeNode dmy = new TreeNode(0);
        TreeNode h = dmy;
        for (Integer i : list) {
            TreeNode treeNode = new TreeNode(i);
            h.right = treeNode;
            h = h.right;
        }
        return dmy.right;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

