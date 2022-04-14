package com.other.offer;

import com.other.model.ListNode;

public class M18 {
    /**
     * 删除链表的节点
     * 给定单项链表的头指针和一个节点指针，定义一个函数在O(1)的时间内删除该节点
     *
     * @param node
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode node) {
        if (null == head || null == node) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (node.next != null) {
            //删除的节点是中间节点
            int t = node.next.val;
            node.val = t;
            node.next = node.next.next;
        } else {
            //删除的节点是头节点或者尾节点
            ListNode cur = dummy;
            while (cur.next != node) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return dummy.next;
    }
}
