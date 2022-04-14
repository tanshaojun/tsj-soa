package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1379. 找出克隆二叉树中的相同节点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 16:28
 */
public class _1379_getTargetCopy {


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Queue<TreeNode> original_queue = new LinkedBlockingQueue<>();
        original_queue.add(original);

        Queue<TreeNode> cloned_queue = new LinkedBlockingQueue<>();
        cloned_queue.add(cloned);

        while (!original_queue.isEmpty()) {
            int size = original_queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode original_poll = original_queue.poll();

                TreeNode cloned_poll = cloned_queue.poll();

                if (original_poll == target) return cloned_poll;

                if (original_poll.left != null) {
                    original_queue.add(original_poll.left);

                    cloned_queue.add(cloned_poll.left);
                }
                if (original_poll.right != null) {
                    original_queue.add(original_poll.right);

                    cloned_queue.add(cloned_poll.right);
                }
            }
        }
        return null;
    }

}
