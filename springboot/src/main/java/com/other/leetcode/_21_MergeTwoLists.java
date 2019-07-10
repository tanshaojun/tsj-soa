package com.other.leetcode;


/**
 * 21. 合并两个有序链表
 */
public class _21_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            ListNode node = null;
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    node = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    node = new ListNode(l1.val);
                    l1 = l1.next;
                }
            } else if (l1 != null) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }
}
