package com.other.offer;

import com.other.model.TreeNode;

import java.util.Objects;

public class M26 {

    /**
     * 树的子结构
     *
     * @param a
     * @param b
     * @return
     */
    public boolean hasSubtree(TreeNode a, TreeNode b) {
        boolean res = false;
        if (a != null && b != null) {
            if (Objects.equals(a.val, b.val)) {
                res = doesTree1HaveTree2(a, b);
            }
            if (!res) {
                //看左子树是否与之相等
                res = hasSubtree(a.left, b);
            }
            if (!res) {
                //看右子树是否与之相等
                res = hasSubtree(a.right, b);
            }
        }
        return res;

    }

    /**
     * 判断两颗树是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public boolean doesTree1HaveTree2(TreeNode a, TreeNode b) {
        if (null == b) return true;
        if (null == a) return false;
        if (Objects.equals(a.val, b.val)) return false;
        return doesTree1HaveTree2(a.left, b.left) && doesTree1HaveTree2(a.right, b.right);
    }

}
