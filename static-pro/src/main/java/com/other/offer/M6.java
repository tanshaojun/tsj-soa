package com.other.offer;

import com.other.model.ListNode;
import com.other.model.TreeNode;

import java.util.Stack;

public class M6 {

    /**
     * 从尾到头打印链表
     *
     * @param root
     * @return
     */
    public void printListRevers(ListNode root) {
        Stack<Integer> stack = new Stack<>();
        ListNode head = root;
        while (null != head) {
            stack.add(head.val);
            head = head.next;
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    /**
     * 递归实现
     *
     * @param root
     */
    public void printListRevers2(ListNode root) {
        if (null != root) {
            if (null != root.next) printListRevers2(root.next);
            System.out.println(root.val);
        }
    }

}
