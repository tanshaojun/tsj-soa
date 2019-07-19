package com.other.leetcode;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/19 10:31
 */
public class _25_ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (tail.next != null) {
            for (int i = 0; i < k && tail != null; i++) tail = tail.next;
            if (tail == null) break;
            //此节点现在是这个反转的开始节点，反转之后会变成尾节点，也是下次反转头结点的前驱节点
            ListNode start = pre.next;
            //保存下一个开始的节点
            ListNode next = tail.next;
            //断开连接
            tail.next = null;
            //反转
            ListNode tmp = null;
            ListNode curr = start;
            while (curr != null) {
                ListNode next1 = curr.next;
                curr.next = tmp;
                tmp = curr;
                curr = next1;
            }
            //拼接反转之后的节点
            pre.next = tmp;
            //将此节点变成下一次反转的前驱节点
            start.next = next;
            //赋值
            pre = start;
            tail = pre;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode result = reverseKGroup(ListNode.getListNode(10), 3);
        System.out.println();
        while (result != null) {
            System.out.print(result.val);
            System.out.print("  ");
            result = result.next;
        }
    }
}
