package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/6 13:34
 */
public class _235_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        TreeNode cur = root;
        getList(p, queue, cur, true);
        return getList(q, queue, cur, false);
    }

    private TreeNode getList(TreeNode t, Queue<TreeNode> queue, TreeNode cur, boolean flag) {
        TreeNode res = null;
        while (cur != null) {
            if (flag) {
                queue.add(cur);
            } else {
                TreeNode poll = queue.poll();
                if (poll == cur) res = poll;
                else return res;
            }
            if (cur == t) break;
            if (cur.val > t.val) {
                cur = cur.left;
            } else if (cur.val < t.val) {
                cur = cur.right;
            }
        }
        return res;
    }

}
