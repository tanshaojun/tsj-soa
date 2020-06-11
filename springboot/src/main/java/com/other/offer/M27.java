package com.other.offer;

import com.other.model.TreeNode;

public class M27 {

    /**
     * 二叉树的镜像
     * <p>
     * 如果一个节点左右节点都不为空，则交换左右节点
     *
     * @param root
     */
    public void mirrorRecursively(TreeNode root) {
        if (null == root) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return;
        }
        root.left = right;
        root.right = left;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

}
