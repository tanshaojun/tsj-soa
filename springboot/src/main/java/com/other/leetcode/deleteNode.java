package com.other.leetcode;

public class deleteNode {
    ListNode head = new ListNode(0);

    public void deleteNode(ListNode node) {
        while (head.next != null) {
            int val = head.val;
            if (val ==  node.val) {

            }
            head = head.next;

        }

    }
}
