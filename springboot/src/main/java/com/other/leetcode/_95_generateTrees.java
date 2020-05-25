package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/25 16:04
 */
public class _95_generateTrees {


    public List<TreeNode> generateTrees(int n) {
        if (0 == n)
            return new LinkedList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = generateTrees(left, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, right);
            for (TreeNode leftNode : lefts) {
                for (TreeNode rightNode : rights) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }

}
