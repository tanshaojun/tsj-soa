package com.other.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 101. 对称二叉树
 */
public class _101_IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            String[] strings = new String[size * 2];
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    strings[count++] = String.valueOf(poll.left.val);
                    queue.add(poll.left);
                } else {
                    strings[count++] = null;
                }
                if (poll.right != null) {
                    strings[count++] = String.valueOf(poll.right.val);
                    queue.add(poll.right);
                } else {
                    strings[count++] = null;
                }
            }
            int l = 0;
            int r = strings.length - 1;
            while (l <= r) {
                if ((strings[l] == null && strings[r] != null) || (strings[l] != null && null == strings[r])) {
                    return false;
                }
                if ((strings[l] != null && strings[r] != null) && !strings[l].equals(strings[r])) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        System.out.println(isSymmetric(treeNode));
    }

}
