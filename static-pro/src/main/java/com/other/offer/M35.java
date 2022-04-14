package com.other.offer;

import java.util.HashMap;
import java.util.Map;

public class M35 {

    /**
     * 复杂链表的复制
     *
     * @param root
     * @return
     */
    public ComplexListNode clone(ComplexListNode root) {
        //复制节点并拼接到后面
        cloneNodes(root);
        //复制sibling节点
        connectSibNode(root);
        //断开节点
        ComplexListNode res = reconnectNodes(root);
        return res;
    }


    /**
     * 复制节点并拼接到后面
     *
     * @param root
     */
    private void cloneNodes(ComplexListNode root) {
        ComplexListNode head = root;
        while (head != null) {
            ComplexListNode clone = new ComplexListNode(head.v);
            clone.next = head.next;
            head.next = clone;
            head = clone.next;
        }
    }

    /**
     * 复制sibling节点
     *
     * @param root
     */
    private void connectSibNode(ComplexListNode root) {
        ComplexListNode head = root;
        while (head != null) {
            ComplexListNode cloneSibling = head.next;
            if (null != head.sibling) {
                cloneSibling.sibling = head.sibling.next;
            }
            head = cloneSibling.next;
        }
    }

    /**
     * 断开节点
     *
     * @param root
     * @return
     */
    private ComplexListNode reconnectNodes(ComplexListNode root) {
        ComplexListNode head = root;
        ComplexListNode dummy = new ComplexListNode(-1);
        ComplexListNode cur = dummy;
        while (head != null) {
            cur.next = head.next;
            cur = cur.next;
            head.next = cur.next;
            head = head.next;
        }
        return dummy.next;
    }


    /**
     * 复杂链表的复制
     *
     * @param root
     * @return
     */
    public ComplexListNode clone1(ComplexListNode root) {

        ComplexListNode head = root;

        Map<ComplexListNode, ComplexListNode> map = new HashMap<>();

        ComplexListNode dummy = new ComplexListNode(-1);
        ComplexListNode cur = dummy;

        while (head != null) {
            ComplexListNode next = new ComplexListNode(head.v);
            cur.next = next;
            cur = cur.next;
            map.put(head, cur);
            head = head.next;
        }
        head = root;
        while (head != null) {
            ComplexListNode complexListNode = map.get(head.sibling);
            map.get(head).sibling = complexListNode;
            head = head.next;
        }

        return dummy.next;
    }

    class ComplexListNode {
        int v;
        ComplexListNode next;
        ComplexListNode sibling;

        public ComplexListNode(int v) {
            this.v = v;
        }
    }

}

