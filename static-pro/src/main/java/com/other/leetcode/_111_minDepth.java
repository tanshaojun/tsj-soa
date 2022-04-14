package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 111. 二叉树的最小深度
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/21 9:41
 */
public class _111_minDepth {


    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) return res;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return res;
    }

}
