package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 160. 相交链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/319:41
 */
public class _160_GetIntersectionNode {
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode rootA = headA;
        int lenA = 1;
        while (rootA.next != null) {
            rootA = rootA.next;
            lenA++;
        }

        ListNode rootB = headB;
        int lenB = 1;
        while (rootB.next != null) {
            rootB = rootB.next;
            lenB++;
        }
        ListNode rootAA = headA;
        ListNode rootBB = headB;
        int dif = 0;
        if (lenB > lenA) {
            dif = lenB - lenA;
            while (dif > 0) {
                dif--;
                rootBB = rootBB.next;
            }
        } else {
            dif = lenA - lenB;
            while (dif > 0) {
                dif--;
                rootAA = rootAA.next;
            }
        }
        while (rootAA != null) {
            if (rootAA == rootBB)
                return rootAA;
            rootAA = rootAA.next;
            rootBB = rootBB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headC = new ListNode(8);


        ListNode headA = new ListNode(5);
        headA.next = new ListNode(0);
        headA.next.next = new ListNode(1);
        headA.next.next.next = headC;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(1);
        headB.next.next = headC;

        System.out.println(getIntersectionNode(headB, headA));
    }
}
