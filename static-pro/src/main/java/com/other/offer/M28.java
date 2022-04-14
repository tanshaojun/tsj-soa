package com.other.offer;

import com.other.model.TreeNode;

import java.util.Objects;

public class M28 {

    /**
     * 对称的二叉树
     * <p>
     * 只需要判断左子树是否和右子树相等就行
     *
     * @param root
     * @return
     */
    public boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    /**
     * 判断左子树是否和右子树相等
     *
     * @param root
     * @param root1
     * @return
     */
    public boolean isSymmetrical(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) return true;
        if (null == root || null == root1) return false;
        if (!Objects.equals(root.val, root1.val)) return false;
        return isSymmetrical(root.left, root1.right) && isSymmetrical(root.right, root1.left);
    }

}
