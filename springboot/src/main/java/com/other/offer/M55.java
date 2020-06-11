package com.other.offer;


import com.other.model.TreeNode;

public class M55 {


    /**
     * 二叉树的深度
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (null == root) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 判断一颗树是不是平衡二叉树(暴力)
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) >= 2) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 判断一颗树是不是平衡二叉树(遍历一次)
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return process(root).b;
    }

    private Result process(TreeNode root) {
        if (null == root) return new Result(0, true);
        Result left = process(root.left);
        Result right = process(root.right);
        if (left.b && right.b) {
            int abs = Math.abs(left.depth - right.depth);
            if (abs >= 2) return new Result(0, false);
            return new Result(Math.max(left.depth, right.depth) + 1, true);
        }
        return new Result(0, false);
    }

    class Result {
        int depth;
        boolean b;

        public Result(int depth, boolean b) {
            this.depth = depth;
            this.b = b;
        }
    }

}
