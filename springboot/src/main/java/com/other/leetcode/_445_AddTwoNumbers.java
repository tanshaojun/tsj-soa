package com.other.leetcode;

import com.other.model.ListNode;
import com.utils.NodeUtil;

import java.util.Stack;

/**
 * 445. 两数相加 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/17 14:28
 */
public class _445_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        Stack<Integer> stack1 = new Stack<>();
        ListNode r1 = l1;
        while (r1 != null) {
            stack1.push(r1.val);
            r1 = r1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        ListNode r2 = l2;
        while (r2 != null) {
            stack2.push(r2.val);
            r2 = r2.next;
        }
        ListNode dummy = new ListNode(0);
        int count = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int i = stack1.pop() + stack2.pop() + count;
            count = i / 10;
            ListNode t = new ListNode(i % 10);
            t.next = dummy.next;
            dummy.next = t;
        }
        while (!stack1.isEmpty()) {
            int i = stack1.pop() + count;
            count = i / 10;
            ListNode t = new ListNode(i % 10);
            t.next = dummy.next;
            dummy.next = t;
        }
        while (!stack2.isEmpty()) {
            int i = stack2.pop() + count;
            count = i / 10;
            ListNode t = new ListNode(i % 10);
            t.next = dummy.next;
            dummy.next = t;
        }
        if (count == 1) {
            ListNode t = new ListNode(count);
            t.next = dummy.next;
            dummy.next = t;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = NodeUtil.getListNode(10, 10);
        ListNode root = listNode;
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
        ListNode listNode1 = addTwoNumbers(listNode, listNode);
        root = listNode1;
        System.out.println();
        while (root != null) {
            System.out.print(root.val);
            System.out.print("  ");
            root = root.next;
        }
    }

}
