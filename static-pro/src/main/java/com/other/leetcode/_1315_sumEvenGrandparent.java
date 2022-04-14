package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 16:51
 */
public class _1315_sumEvenGrandparent {

    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (null == root) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int val = root.val;
        if (val % 2 == 0 && null != left) {
            res += left.left != null ? left.left.val : 0;
            res += left.right != null ? left.right.val : 0;
        }
        if (val % 2 == 0 && null != right) {
            res += right.left != null ? right.left.val : 0;
            res += right.right != null ? right.right.val : 0;
        }
        sumEvenGrandparent(left);
        sumEvenGrandparent(right);
        return res;

    }
}
