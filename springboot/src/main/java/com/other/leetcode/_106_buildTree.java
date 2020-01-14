package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 9:50
 */
public class _106_buildTree {

    int len = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> catah = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) catah.put(inorder[i], i);
        len = postorder.length - 1;
        return build(0, postorder.length - 1, postorder, catah);
    }

    private TreeNode build(int left, int right, int[] postorder, Map<Integer, Integer> catah) {
        if (left > right) return null;
        TreeNode root = new TreeNode(postorder[len--]);
        Integer index = catah.get(root.val);
        root.right = build(index + 1, right, postorder, catah);
        root.left = build(left, index - 1, postorder, catah);
        return root;
    }
}
