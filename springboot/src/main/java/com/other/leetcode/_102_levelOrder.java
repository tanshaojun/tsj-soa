package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. 二叉树的层次遍历
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/27 16:14
 */
public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) return res;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (null != poll.left)
                    queue.add(poll.left);
                if (null != poll.right)
                    queue.add(poll.right);
                list.add(poll.val);
            }
            res.add(list);
        }
        return res;
    }
}
