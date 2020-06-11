package com.other.offer;

import com.other.model.ListNode;

public class M25 {

    /**
     * 合并两个排序的链表
     * 这里我选择让所有的节点往a链表合并
     * 设置一个前驱节点，当a小于cur时，cur直接下一个
     * 当a不小于cur时，先记录b的下一个节点next，然后把pre的下一个节点指向b，然后把pre的下一个下一个节点指向cur，最后把next赋值给b
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        dummy.next = a;
        ListNode pre = dummy;
        ListNode cur = a;
        while (b != null) {
            if (cur != null && cur.val < b.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode next = b.next;
                pre.next = b;
                pre.next.next = cur;
                pre = pre.next;
                b = next;
            }
        }
        return dummy.next;
    }

}
