package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 234. 回文链表
 */
public class _234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (null == head) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = fast;
            fast = slow;
            slow = next;
        }

        while (fast != null) {
            if (fast.val != head.val) return false;
            fast = fast.next;
            head = head.next;
        }
        return true;
    }
}
