package com.other.leetcode;

public class hasCycle {
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
