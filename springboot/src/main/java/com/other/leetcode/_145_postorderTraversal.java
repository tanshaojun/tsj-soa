package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 16:36
 */
public class _145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) return new ArrayList<>();
        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.push(pop);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }
        List<Integer> list = new ArrayList<>();
        while (!res.isEmpty()) {
            list.add(res.pop().val);
        }
        return list;
    }
}
