package com.other.leetcode;

/**
 * 206. 反转链表
 */
public class _206_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || (head != null && head.next == null)) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        return head;

    }
}
