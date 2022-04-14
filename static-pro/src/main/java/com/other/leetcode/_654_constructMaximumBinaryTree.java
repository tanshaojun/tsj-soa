package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 654. 最大二叉树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 14:30
 */
public class _654_constructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode res = maxTree(0, nums.length - 1, nums);
        return res;
    }

    private TreeNode maxTree(int left, int right, int[] nums) {
        if (left > right) return null;
        int max = Integer.MIN_VALUE;
        int index = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = maxTree(left, index - 1, nums);
        root.right = maxTree(index + 1, right, nums);
        return root;
    }
}
