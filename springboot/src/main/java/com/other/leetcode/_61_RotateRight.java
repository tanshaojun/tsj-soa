package com.other.leetcode;

/**
 * 61. 旋转链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/17 15:52
 */
public class _61_RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        if (null == head) return head;
        if (k == 0) return head;
        int count = 0;
        ListNode root = head;
        while (root != null) {
            count++;
            root = root.next;
        }
        int size = k % count;
        if (size == 0) return head;
        count = count - size - 1;
        root = head;
        while (count > 0) {
            count--;
            root = root.next;
        }
        ListNode tmp = root.next;
        root.next = null;
        root = tmp;
        while (root.next != null)
            root = root.next;
        root.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(2);
        ListNode root = listNode;
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
        ListNode listNode1 = rotateRight(listNode, 9);
        root = listNode1;
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
    }
}
