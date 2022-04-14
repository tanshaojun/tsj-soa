package com.other.leetcode;


/**
 * 138. 复制带随机指针的链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 10:06
 */
public class _138_copyRandomList {

    public Node copyRandomList(Node head) {
        if (null == head) return null;
        Node cur = head;
        while (null != cur) {
            Node node = new Node(cur.val, null, null);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        //设置random节点
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        cur = head;
        Node res = cur.next;
        //分割链表
        while (cur != null) {
            Node next = cur.next;
            cur.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
