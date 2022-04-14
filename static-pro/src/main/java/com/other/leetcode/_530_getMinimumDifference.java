package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/22 11:37
 */
public class _530_getMinimumDifference {

    /**
     * 中序遍历找最小值
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (null == root) return 0;
        int min = Integer.MAX_VALUE;
        TreeNode pre = null;
        TreeNode cur = root;
        while (null != cur) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    //先序遍历打印
//                    System.out.print(cur.val);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                //先序遍历打印
//                System.out.print(cur.val);
            }
            if (null != pre) min = Math.min(min, cur.val - pre.val);
            pre = cur;
            cur = cur.right;
        }
        return min;
    }

}
