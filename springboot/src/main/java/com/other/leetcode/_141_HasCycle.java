package com.other.leetcode;

/**
 * 141. 环形链表
 */
public class _141_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode a = head;
        ListNode b = head.next;
        while (b != null && b.next != null) {
            if (a.next == b.next.next) {
                return true;
            }
            a = a.next;
            b = b.next.next;
        }
        return false;
    }
}
