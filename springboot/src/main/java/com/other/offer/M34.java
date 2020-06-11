package com.other.offer;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M34 {

    List<Integer> list = new ArrayList<>();

    /**
     * 二叉树中和为某一值的路径
     * <p>
     * 前序遍历二叉树，list保存节点,遇到没有孩子节点并且等于k，则打印
     *
     * @param root
     * @param k
     */
    public void findPath(TreeNode root, int k) {
        if (null == root) return;
        if (root.left == null && root.right == null && k == root.val) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println(root.val);
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            findPath(root.left, k - root.val);
        }
        if (root.right != null) {
            findPath(root.right, k - root.val);
        }
        list.remove(list.size() - 1);
    }

}
