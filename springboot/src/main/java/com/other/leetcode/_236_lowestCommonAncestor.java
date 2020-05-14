package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 10:07
 */
public class _236_lowestCommonAncestor {


    Map<Integer, TreeNode> parentMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        dfs(root);
        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) return q;
            q = parentMap.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {

        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }

    }

}
