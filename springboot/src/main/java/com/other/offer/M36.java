package com.other.offer;

public class M36 {

    /**
     * 二叉搜索树与双向链表
     *
     * @param root
     * @return
     */
    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode last = null;
        convertNode(root, last);
        BinaryTreeNode head = last;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertNode(BinaryTreeNode root, BinaryTreeNode last) {
        if (root == null) return;
        BinaryTreeNode cur = root;
        if (cur.left != null) {
            convertNode(cur.left, last);
        }
        cur.left = last;
        if (last != null) {
            last.right = cur;
        }
        last = cur;
        if (cur.right != null) {
            convertNode(cur.right, last);
        }
    }


    class BinaryTreeNode {
        int v;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }
}
