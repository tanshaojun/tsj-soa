package com.other.leetcode;

/**
 * 203. 移除链表元素
 */
public class _203_RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(-1);
        tmp.next = head;
        ListNode cur = tmp;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return tmp.next;
    }
}
