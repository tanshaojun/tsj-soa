package com.other.leetcode;

/**
 * 147. 对链表进行插入排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/9 15:18
 */
public class _147_InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (null == head) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode insert = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
                continue;
            }
            //找到插入位置
            while (insert.next.val < cur.next.val)
                insert = insert.next;
            //交换
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = insert.next;
            insert.next = next;
            //将排好序的链表重新赋值
            insert = dummy;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-1);
        root.next = new ListNode(5);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(0);

//        ListNode next = root.next;
//        root.next = next.next;
//        next.next = root;
//        root = next;
//        System.out.println(root);

        ListNode listNode = insertionSortList(root);
    }
}
