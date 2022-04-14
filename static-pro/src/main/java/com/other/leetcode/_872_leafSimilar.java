package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 872. 叶子相似的树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 9:56
 */
public class _872_leafSimilar {

    private boolean res = true;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) return true;
        if (null != root1 && null == root2) return false;
        if (null == root1 && null != root2) return false;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        addQueue(root1, queue, true);
        addQueue(root2, queue, false);
        return res;
    }

    private void addQueue(TreeNode root1, Queue<Integer> queue, boolean flag) {
        if (!res) return;
        if (null == root1) return;
        if (null == root1.left && null == root1.right) {
            if (flag) {
                queue.add(root1.val);
            } else {
                if (queue.isEmpty() || !queue.poll().equals(root1.val)) {
                    res = false;
                    return;
                }
            }
            return;
        }
        addQueue(root1.left, queue, flag);
        addQueue(root1.right, queue, flag);
    }

}
