package com.other.leetcode;

import com.other.model.TreeNode;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 15:37
 */
public class _199_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        rightSideView(root, 0, res);
        return res;
    }

    public void rightSideView(TreeNode root, int depth, List<Integer> res) {
        if (null == root) return;
        if (depth == res.size()) res.add(root.val);
        //优先遍历右边，如果右边有值则添加
        rightSideView(root.right, depth + 1, res);
        rightSideView(root.left, depth + 1, res);
    }
}
