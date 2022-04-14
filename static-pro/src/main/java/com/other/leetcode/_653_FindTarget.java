package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class _653_FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        return dfs(root, k, hashSet);
    }

    private boolean dfs(TreeNode root, int k, HashSet<Integer> hashSet) {
        if (root == null) return false;
        int val = root.val;
        boolean contains = hashSet.contains(k - val);
        if (contains) return contains;
        hashSet.add(val);
        return dfs(root.right, k, hashSet) || dfs(root.left, k, hashSet);
    }


    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = bts(root);
        for (int i = 0; i < list.size(); i++) {
            int i1 = k - list.get(i);
            boolean contains = list.subList(i + 1, list.size() - 1).contains(i1);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    List<Integer> integerList = new ArrayList<>();

    private List<Integer> bts(TreeNode root) {
        if (root == null) {
            return integerList;
        }
        bts(root.left);
        integerList.add(root.val);
        bts(root.right);
        return integerList;
    }
}
