package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @Author tansj
 * @Date 2021-05-10 11:09
 * @Version 1.0
 */
public class _993_isCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (null == root) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        Queue<Integer> indexQueue = new LinkedBlockingQueue<>();
        queue.add(root);
        indexQueue.add(1);
        while (!queue.isEmpty()) {
            int xIndex = -1;
            int yIndex = -1;
            int size = queue.size();
            boolean xb = false;
            boolean yb = false;
            for (int i = 0; i < size; i++) {
                TreeNode target = queue.poll();
                Integer idx = indexQueue.poll();
                int val = target.val;
                if (val == x) {
                    xb = true;
                    xIndex = idx;
                } else if (val == y) {
                    yb = true;
                    yIndex = idx;
                }
                if (xb && yb && (xIndex != yIndex)) {
                    return true;
                }
                if (target.left != null) {
                    queue.add(target.left);
                    indexQueue.add(i);
                }
                if (target.right != null) {
                    queue.add(target.right);
                    indexQueue.add(i);
                }
            }
        }
        return false;
    }

}
