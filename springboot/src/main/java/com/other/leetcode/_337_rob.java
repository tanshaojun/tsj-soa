package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 337. 打家劫舍 III
 *
 * @Author tansj
 * @Date 2021-05-12 13:09
 * @Version 1.0
 */
public class _337_rob {

    public int rob(TreeNode root) {
        int[] result = process(root);
        return Math.max(result[0], result[1]);
    }

    public int[] process(TreeNode root) {
        int[] result = new int[2];
        if (root != null) {
            int[] left = process(root.left);
            int[] right = process(root.right);
            // 0 表示不偷根节点，那么可以选择下一个偷或不偷的最大值
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            // 1 表示偷根节点
            result[1] = left[0] + right[0] + root.val;
        }
        return result;
    }

}
