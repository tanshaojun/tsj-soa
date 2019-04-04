package com.other.leetcode;

public class middleNode {
    public static ListNode middleNode(ListNode head) {
        ListNode h = head;
        int sum = 0;
        while (h != null) {
            sum++;
            h = h.next;
        }
        ListNode h1 = head;
        int sum1 = 0;
        while (h1 != null) {
            sum1++;
            if (sum1 == (sum / 2) + 1) return h1;
            h1 = h1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
//        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
        ListNode listNode = middleNode(h);
        System.out.println(listNode);
    }
}
