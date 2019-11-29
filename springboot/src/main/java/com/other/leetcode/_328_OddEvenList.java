package com.other.leetcode;

import com.other.model.ListNode;
import com.utils.NodeUtil;

/**
 * 328. 奇偶链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/16 19:28
 */
public class _328_OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy.next;
        ListNode fast = slow.next;
        ListNode r = fast.next;
        while (r != null && r.next != null) {
            ListNode next = r.next.next;
            r.next.next = null;

            fast.next = r.next;
            fast = fast.next;

            r.next = slow.next;
            slow.next = r;
            slow = slow.next;

            r = next;
        }
        if (r != null) {
            fast.next = null;
            r.next = slow.next;
            slow.next = r;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = NodeUtil.getListNode(3,10);
        ListNode root = listNode;
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
        ListNode listNode1 = oddEvenList(listNode);
        root = listNode1;
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
    }
}
