package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 173. 二叉搜索树迭代器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/4 10:52
 */
public class _173_BSTIterator {

    private Stack<TreeNode> stack;

    public _173_BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (null != root) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (null != node) {
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
