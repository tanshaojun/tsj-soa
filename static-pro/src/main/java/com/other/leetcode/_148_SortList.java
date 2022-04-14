package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 148. 排序链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/10 10:26
 */
public class _148_SortList {

    /**
     * 链表的归并排序
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return merge(right, left);
    }

    private static ListNode merge(ListNode right, ListNode left) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (right != null && left != null) {
            if (right.val > left.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = right == null ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(55);
        root.next = new ListNode(1);
        root.next.next = new ListNode(9);
        root.next.next.next = new ListNode(-1);
        root.next.next.next.next = new ListNode(-8);
        root.next.next.next.next.next = new ListNode(20);
        ListNode listNode = sortList(root);
        System.out.println();


    }
}
