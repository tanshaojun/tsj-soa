package com.other.leetcode;

import com.other.model.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class _589_Preorder {
    public List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node n : root.children) {
            preorder(n);
        }
        return res;
    }
}
