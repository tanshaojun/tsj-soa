package com.other.leetcode;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/18 10:44
 */
public class _19_RemoveNthFromEnd {

    /**
     * 官方题解 一次遍历 双指针
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    /**
     * 自己写的两次遍历
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (null == head) return head;
        if (0 == n) return head;
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        if (n == size) return head.next;
        while (cur.next != null) {
            size--;
            if (size == n) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(10);
        ListNode listNode1 = removeNthFromEnd(listNode, 10);
        System.out.println();
        while (listNode1 != null) {
            System.out.print(listNode1.val);
            System.out.print("  ");
            listNode1 = listNode1.next;
        }
    }
}
