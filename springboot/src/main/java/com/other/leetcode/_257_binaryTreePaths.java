package com.other.leetcode;

import com.other.model.TreeNode;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 257. 二叉树的所有路径
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 16:50
 */
public class _257_binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;

    }

    private void dfs(TreeNode root, List<String> res, String s) {
        if (null == root) return;
        if (null == root.left && null == root.right) {
            s += String.valueOf(root.val);
            res.add(s);
        } else {
            s += String.valueOf(root.val);
            dfs(root.left, res, s + "->");
            dfs(root.right, res, s + "->");
        }
    }
}
