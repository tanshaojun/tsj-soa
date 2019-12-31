package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/30 15:21
 */
public class _1302_deepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (null == root) return 0;
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (null != poll.left)
                    queue.add(poll.left);
                if (null != poll.right)
                    queue.add(poll.right);
                res += poll.val;
            }
        }
        return res;
    }

}
