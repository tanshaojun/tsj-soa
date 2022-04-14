package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 142. 环形链表 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/18 18:03
 */
public class _142_DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if (null == head) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                tmp = slow;
                break;
            }
        }
        if (tmp == null) return tmp;
        fast = head;
        while (tmp != fast) {
            fast = fast.next;
            tmp = tmp.next;
        }

        return tmp;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        root.next = listNode1;
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = listNode1;
//        root.next.next.next.next = root;
        ListNode listNode = detectCycle(root);
        System.out.println(listNode.val);
    }

}
