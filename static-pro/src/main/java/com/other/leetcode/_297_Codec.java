package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 9:45
 */
public class _297_Codec {

    /**
     * 序列化二叉树
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append("$,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 反序列化二叉树
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        List<String> arr = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserialize(arr);
    }

    public TreeNode deserialize(List<String> arr) {
        if (!arr.get(0).equals("$")) {
            TreeNode root = new TreeNode(Integer.valueOf(arr.get(0)));
            arr.remove(0);
            root.left = deserialize(arr);
            arr.remove(0);
            root.right = deserialize(arr);
            return root;
        }
        return null;
    }

}
