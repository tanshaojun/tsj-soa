package com.utils;

import com.other.model.ListNode;

import java.util.Random;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/28 11:41
 */
public class NodeUtil {

    /**
     * 返回一个长度为size，值在0-bound之间的链表
     *
     * @param size
     * @param bound
     * @return
     */
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
