package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/18 19:17
 */
public class _82_DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tmp = dummy.next;
        boolean flag = false;
        while (tmp != null && tmp.next != null) {
            if (tmp.val != tmp.next.val) {
                if (flag) {
                    flag = false;
                } else {
                    cur.next = tmp;
                    cur = cur.next;
                }
            } else
                flag = true;

            tmp = tmp.next;
        }
        if (flag)
            cur.next = null;
        else
            cur.next = tmp;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(6);
        ListNode listNode = deleteDuplicates(root);
        System.out.println();
    }

}
