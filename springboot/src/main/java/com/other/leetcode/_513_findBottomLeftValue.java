package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 513. 找树左下角的值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/3 10:04
 */
public class _513_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        int res = -1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (0 == i) res = t.val;
                if (null != t.left)
                    queue.add(t.left);
                if (null != t.right)
                    queue.add(t.right);
            }
        }
        return res;
    }

}
