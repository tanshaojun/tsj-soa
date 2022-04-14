package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 23. 合并K个排序链表
 */
public class _23_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = merge(listNode, lists[i]);
        }
        return listNode;
    }

    public ListNode merge(ListNode start, ListNode end) {
        if (start == null) return end;
        if (end == null) return start;
        ListNode root = new ListNode(0);
        ListNode listNode = root;
        while (start != null && end != null) {
            if (start.val > end.val) {
                listNode.next = end;
                end = end.next;
            } else {
                listNode.next = start;
                start = start.next;
            }
            listNode = listNode.next;
        }
        if (start == null) listNode.next = end;
        else listNode.next = start;
        return root.next;
    }


}
