package com.other.leetcode;


import com.other.model.ListNode;

/**
 * 2 两数相加
 */
public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int count = 0;
        while (l1 != null || l2 != null || count != 0) {
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            int sum = s1 + s2 + count;
            count = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head;
    }
}
