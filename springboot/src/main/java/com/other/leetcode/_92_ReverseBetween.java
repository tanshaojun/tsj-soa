package com.other.leetcode;

/**
 * 92. 反转链表 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/27 20:06
 */
public class _92_ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        if (m < 1) m = 1;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode prve = dump;
        //找到翻转节点的前驱
        for (int i = 0; i < m - 1; i++)
            prve = prve.next;
        ListNode cur = prve.next;
        ListNode tmp = null;
        //反转m-n的节点
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            //当N大于链表长度时
            if (null == next) {
                cur.next = tmp;
                tmp = cur;
                cur = null;
                break;
            }
            cur.next = tmp;
            tmp = cur;
            cur = next;
        }
        //加上翻转的节点
        prve.next = tmp;
        while (prve.next != null)
            prve = prve.next;
        //补上m之后的节点
        while (cur != null) {
            prve.next = cur;
            prve = prve.next;
            cur = cur.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode he = new ListNode(1);
        he.next = new ListNode(2);
        he.next.next = new ListNode(3);
        he.next.next.next = new ListNode(4);
        he.next.next.next.next = new ListNode(5);
        he.next.next.next.next.next = new ListNode(6);
        ListNode listNode = reverseBetween(he, 0, 9);
        System.out.println();

    }
}
