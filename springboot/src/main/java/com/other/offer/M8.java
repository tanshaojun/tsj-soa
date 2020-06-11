package com.other.offer;


public class M8 {

    /**
     * 二叉树的下一个节点
     * 给定一颗二叉树和其中的一个节点，找到其后继节点(中序遍历中的下一个节点就是后继节点)
     * <p>
     * 1.如果一个节点有右子树，那么后继节点就是右子树中的最左节点。
     * 2.如果一个节点无右子树并且是它父节点的左节点，那么它的后继节点就是父节点。
     * 3.如果一个节点无右子树并且是它父节点的右节点，那么沿着父节点向上遍历，找到一个节点是它父节点的左孩子节点，
     * 如果该节点存在，那么这个节点的父节点就是后继节点。
     *
     * @param root
     * @param cur
     * @return
     */
    public Node getNext(Node root, Node cur) {
        if (null == root || null == cur) return root;
        //默认该节点已存在
        if (cur.right != null) {
            Node right = cur.right;
            while (right.left != null && right.left.left != null)
                right = right.left;
            return right;
        } else {
            Node parent = cur.parent;
            if (parent.left == cur) return parent;
            if (parent.right == cur) {
                while (parent.parent != null) {
                    Node parentParent = parent.parent;
                    if (parentParent.left == parent)
                        return parentParent;
                    parent = parent.parent;
                }
            }
        }
        return null;
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

}