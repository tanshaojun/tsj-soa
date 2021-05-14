package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1457. 二叉树中的伪回文路径
 *
 * @Author tansj
 * @Date 2021-05-10 15:28
 * @Version 1.0
 */
public class _1457_pseudoPalindromicPaths {

    int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        process(root, new int[10]);
        return res;
    }

    private void process(TreeNode root, int[] t) {
        if (null == root) {
            return;
        }
        t[root.val]++;
        process(root.left, t);
        process(root.right, t);
        if (root.left == null && root.right == null) {
            int oddNumber = 0;
            for (int i = 0; i < t.length; i++) {
                int j = t[i];
                if (j % 2 != 0 && oddNumber > 0) {
                    oddNumber++;
                    break;
                }
                if (j % 2 != 0 && oddNumber == 0) {
                    oddNumber++;
                }
            }
            if (oddNumber <= 1) {
                res++;
            }
        }
        t[root.val]--;
    }

}
