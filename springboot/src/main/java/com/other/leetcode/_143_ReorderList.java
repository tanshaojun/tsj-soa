package com.other.leetcode;

/**
 * 143. 重排链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/17 17:19
 */
public class _143_ReorderList {

    public static void reorderList(ListNode head) {
        if (null == head || null == head.next) return;
        //找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转
        fast = slow.next;
        ListNode t = null;
        while (fast.next != null) {
            ListNode next = fast.next;
            fast.next = t;
            t = fast;
            fast = next;
        }
        fast.next = t;
        //拼接
        slow = head;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = slow.next.next;
            fast = next;
        }
        slow.next = null;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(4);
        reorderList(listNode);
    }

}
