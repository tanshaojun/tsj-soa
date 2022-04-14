package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 15:28
 */
public class _144_preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (null != pop.right) stack.push(pop.right);
            if (null != pop.left) stack.push(pop.left);
        }
        return res;
    }

}
