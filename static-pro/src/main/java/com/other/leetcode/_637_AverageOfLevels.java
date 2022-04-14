package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 */
public class _637_AverageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (null == root) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                sum += t.val;
                if (null != t.left)
                    queue.add(t.left);
                if (null != t.right)
                    queue.add(t.right);
            }
            double avg = sum / size;
            list.add(avg);
        }
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }
}
