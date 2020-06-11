package com.other.offer;

import com.other.model.TreeNode;

public class M37 {


    /**
     * 反序列化二叉树
     *
     * @param s
     */
    public TreeNode deSerialize(String s) {
        if (s.charAt(index) != '$') {
            TreeNode root = new TreeNode(s.charAt(index));
            index++;
            root.left = deSerialize(s);
            index++;
            root.right = deSerialize(s);
            return root;
        }
        return null;

    }

    static int index = 0;

    /**
     * 序列化二叉树
     *
     * @param root
     */
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();

    }

    public void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("$");
            return;
        }
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

}
