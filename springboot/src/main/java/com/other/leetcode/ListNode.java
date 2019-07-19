package com.other.leetcode;

import java.util.Random;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode getListNode(int size) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < size; i++) {
            head.next = new ListNode(new Random().nextInt(10));
            head = head.next;
        }
        ListNode next = dummy.next;
        while (next != null) {
            System.out.print(next.val);
            System.out.print("  ");
            next = next.next;
        }
        return dummy.next;
    }

    public static ListNode getListNode(int size, int bound) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < size; i++) {
            head.next = new ListNode(new Random().nextInt(bound));
            head = head.next;
        }
        ListNode next = dummy.next;
        while (next != null) {
            System.out.print(next.val);
            System.out.print("  ");
            next = next.next;
        }
        return dummy.next;
    }
}
