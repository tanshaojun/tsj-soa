package com.other.offer;

import com.other.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M7 {

    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树（不含重复的数字）
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode construct(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeNode(0, inorder.length - 1, map, preorder);

    }

    private TreeNode buildTreeNode(int left, int right, Map<Integer, Integer> map, int[] preorder) {
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[left++]);
        Integer index = map.get(root.val);
        root.left = buildTreeNode(left, index - 1, map, preorder);
        root.right = buildTreeNode(index + 1, right, map, preorder);
        return root;
    }

}