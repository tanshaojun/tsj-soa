package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/9 11:09
 */
public class _105_buildTree {

    int len = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, preorder.length - 1, map, preorder);
    }

    private TreeNode build(int left, int right, Map<Integer, Integer> map, int[] preorder) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[len++]);
        Integer index = map.get(root.val);
        root.left = build(left, index - 1, map, preorder);
        root.right = build(index + 1, right, map, preorder);
        return root;
    }

}
