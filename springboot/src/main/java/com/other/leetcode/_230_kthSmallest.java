package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 17:20
 */
public class _230_kthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            k--;
            if (k == 0) {
                result = pop.val;
                break;
            }
            if (null != pop.right) root = pop.right;
        }
        return result;
    }

}
