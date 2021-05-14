package com.other.leetcode;

import com.other.model.TreeNode;

/**
 * 1028. 从先序遍历还原二叉树
 *
 * @Author tansj
 * @Date 2021-05-12 10:05
 * @Version 1.0
 */
public class _1028_recoverFromPreorder {

    public TreeNode recoverFromPreorder(String S) {
        return process(S, 0, S.length() - 1, 1);

    }

    private TreeNode process(String s, int left, int right, int depth) {
        if (left > right) {
            return null;
        }
        int v = 0;
        for (; left <= right; left++) {
            if (s.charAt(left) == '-') {
                break;
            }
            v = v * 10 + (s.charAt(left) - '0');
        }
        TreeNode root = new TreeNode(v);
        if (left == right) {
            return root;
        }
        //找左边
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '-') {
                count++;
            } else if (depth == count) {
                left = i;
                break;
            }
        }

        //过滤多位数字
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '-') {
                break;
            }
        }

        //找右边开头
        count = 0;
        int mid = -1;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '-') {
                count++;
            } else {
                if (depth == count) {
                    mid = i;
                    break;
                }
                count = 0;
            }
        }
        if (mid != -1) {
            root.left = process(s, left, mid - depth - 1, depth + 1);
            root.right = process(s, mid, right, depth + 1);
        } else {
            //无右节点
            root.left = process(s, left, right, depth + 1);
        }
        return root;

    }
}
