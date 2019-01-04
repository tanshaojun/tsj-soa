package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

public class preorder {
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
