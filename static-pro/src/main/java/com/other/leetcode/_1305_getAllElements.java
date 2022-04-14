package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/2 17:39
 */
public class _1305_getAllElements {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        add(root1, res);
        add(root2, res);
        Collections.sort(res);
        return res;
    }

    private void add(TreeNode root, List<Integer> res) {
        if (null == root) return;
        add(root.left, res);
        res.add(root.val);
        add(root.right, res);
    }

}
