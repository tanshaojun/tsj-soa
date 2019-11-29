package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 */
public class _83_DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == tmp.val) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode he = new ListNode(1);
        he.next = new ListNode(2);
        he.next.next = new ListNode(3);
        he.next.next.next = new ListNode(3);
        he.next.next.next.next = new ListNode(3);
        he.next.next.next.next.next = new ListNode(4);
        System.out.println(deleteDuplicates(he));
    }
}
