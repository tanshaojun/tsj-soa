package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 515. 在每个树行中找最大值
 *
 * @Author tansj
 * @Date 2021-05-10 15:49
 * @Version 1.0
 */
public class _515_largestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode target = queue.poll();
                max = Math.max(target.val, max);
                if (target.left != null) {
                    queue.add(target.left);
                }
                if (target.right != null) {
                    queue.add(target.right);
                }
            }
            res.add(max);
        }
        return res;
    }

}
