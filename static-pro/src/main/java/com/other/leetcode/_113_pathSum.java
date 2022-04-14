package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/27 17:07
 */
public class _113_pathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> inner = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        sum -= root.val;
        inner.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(inner));
            }
        }
        if (root.left != null) pathSum(root.left, sum);
        if (root.right != null) pathSum(root.right, sum);
        inner.remove(inner.size() - 1);
        return res;
    }
}
