package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 237. 删除链表中的节点
 */
public class _237_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
