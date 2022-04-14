package com.other.leetcode;

import com.other.model.ListNode;
import com.utils.NodeUtil;

/**
 * 86. 分隔链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/17 13:42
 */
public class _86_Partition {


    public static ListNode partition(ListNode head, int x) {
        if (null == head) return head;
        ListNode dummy = new ListNode(x);
        dummy.next = head;
        ListNode root = dummy;
        ListNode largeDummy = new ListNode(x);
        ListNode large = largeDummy;
        while (root.next != null) {
            if (root.next.val >= x) {
                large.next = root.next;
                large = large.next;
                root.next = root.next.next;
            } else {
                root = root.next;
            }
        }
        large.next = null;
        root.next = largeDummy.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = NodeUtil.getListNode(5,10);
        ListNode root = listNode;
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
        ListNode listNode1 = partition(listNode, 50);
        root = listNode1;
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
    }


}
