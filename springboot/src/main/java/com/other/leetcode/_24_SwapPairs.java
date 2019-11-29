package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/28 14:09
 */
public class _24_SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (null == head) return head;
        ListNode dump = new ListNode(0);
        ListNode result = dump;
        ListNode cur = head;
        ListNode t = null;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = t;
            t = cur;
            cur = next;
            if (t.next != null) {
                result.next = t;
                result = result.next.next;
                t = null;
            }
        }
        result.next = cur;
        if (null != t)
            result.next.next = t;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode he = new ListNode(1);
        he.next = new ListNode(2);
//        he.next.next = new ListNode(3);
//        he.next.next.next = new ListNode(4);
//        he.next.next.next.next = new ListNode(5);
//        he.next.next.next.next.next = new ListNode(6);
        ListNode listNode = swapPairs(he);
        System.out.println();
    }

}
