package com.other.offer;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class M32 {

    /**
     * 从上到下打印二叉树(二叉树的层次遍历)
     *
     * @param root
     */
    public void printFromTopToBottom(TreeNode root) {
        if (null == root) return;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode r = queue.poll();
                System.out.print(r.val);
                if (r.left != null) queue.add(r.left);
                if (r.right != null) queue.add(r.right);
            }
        }
    }


}
