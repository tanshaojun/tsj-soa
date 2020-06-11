package com.other.offer;


import com.other.model.TreeNode;

public class M54 {


    /**
     * 二叉搜索树的第k大节点
     *
     * @param root
     * @return
     */
    public TreeNode kthNode(TreeNode root, int k) {
        int count = 0;
        TreeNode cur = root;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (null != mostRight) {
                //如果有左孩子，mostRight指向左孩子最右的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    //mostRight不等于cur，mostRight右孩子设置为cur，cur左移
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    //mostRight等于cur，mostRight右孩子设置为null
                    mostRight.right = null;
                }
            }
            count++;
            if (count == k) return cur;
            //如果没有左孩子，当前节点右移
            cur = cur.right;
        }
        return null;
    }


}
