package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 17:07
 */
public class m27_mirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

}
