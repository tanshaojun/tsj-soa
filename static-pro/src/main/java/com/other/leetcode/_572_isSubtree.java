package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 572. 另一个树的子树o
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/12 13:57
 */
public class _572_isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s) return false;
        return sub(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sub(TreeNode a, TreeNode t) {
        if (a == null && t == null) return true;
        if (a == null || t == null) return false;
        if (a.val != t.val) return false;
        return sub(a.left, t.left) && sub(a.right, t.right);
    }


}
