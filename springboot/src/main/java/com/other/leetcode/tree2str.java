package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1019:05
 */
public class tree2str {
    public static String tree2str(TreeNode t) {
        return tree2str1(t, new StringBuffer("")).toString();
    }

    public static StringBuffer tree2str1(TreeNode t, StringBuffer string) {
        if (t == null) {
            return string;
        }
        string.append(t.val);
        if (t.left != null || t.right != null) {
            string.append("(");
            tree2str1(t.left, string);
            string.append(")");
        }
        if (t.right != null) {
            string.append("(");
            tree2str1(t.right, string);
            string.append(")");
        }
        return string;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

//        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//
//        root.left.right = new TreeNode(4);
        System.out.println(tree2str(root));
    }
}
