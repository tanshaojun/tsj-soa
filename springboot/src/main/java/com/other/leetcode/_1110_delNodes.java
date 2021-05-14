package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1110. 删点成林
 *
 * @Author tansj
 * @Date 2021-05-10 16:02
 * @Version 1.0
 */
public class _1110_delNodes {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<Integer> toDelete = new ArrayList<>();
        for (int i : to_delete) {
            toDelete.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        process(root, toDelete, res);
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
        } else {
            res.add(root);
        }
        return res;
    }

    private boolean process(TreeNode root, List<Integer> toDelete, List<TreeNode> res) {
        if (null == root) {
            return false;
        }
        boolean left = process(root.left, toDelete, res);
        if (left) {
            TreeNode left1 = root.left;
            if (left1.left != null) {
                res.add(left1.left);
            }
            if (left1.right != null) {
                res.add(left1.right);
            }
            root.left = null;
        }
        boolean right = process(root.right, toDelete, res);
        if (right) {
            TreeNode right1 = root.right;
            if (right1.left != null) {
                res.add(right1.left);
            }
            if (right1.right != null) {
                res.add(right1.right);
            }
            root.right = null;
        }
        int val = root.val;
        if (toDelete.contains(val)) {
            return true;
        }
        return false;
    }

}
