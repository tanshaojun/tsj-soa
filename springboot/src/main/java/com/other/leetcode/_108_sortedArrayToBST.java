package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 10:44
 */
public class _108_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums) return null;
        int len = nums.length;
        return sortedArrayToBST(nums, 0, len - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }

}
