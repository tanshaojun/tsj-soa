package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 1161. 最大层内元素和
 *
 * @Author tansj
 * @Date 2021-05-10 15:18
 * @Version 1.0
 */
public class _1161_maxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int level = 1;
        int max = Integer.MIN_VALUE;
        int levelMin = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode target = queue.poll();
                sum += target.val;
                if (target.left != null) {
                    queue.add(target.left);
                }
                if (target.right != null) {
                    queue.add(target.right);
                }
            }
            if (sum > max) {
                max = sum;
                levelMin = level;
            }
            level++;
        }
        return levelMin;
    }
}
