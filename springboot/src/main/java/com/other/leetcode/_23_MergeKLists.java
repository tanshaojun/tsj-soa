package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 23. 合并K个排序链表
 */
public class _23_MergeKLists {
    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(4);
        start.next.next = new ListNode(5);

        ListNode end = new ListNode(1);
        end.next = new ListNode(3);
        end.next.next = new ListNode(4);


        ListNode end1 = new ListNode(2);
        end1.next = new ListNode(6);


        ListNode[] lists = new ListNode[]{start, end, end1};
        ListNode merge = mergeKLists(lists);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = null;
        for (int i = 0; i < lists.length; i++) {
            listNode = merge(listNode, lists[i]);
        }
        return listNode;
    }

    public static ListNode merge(ListNode start, ListNode end) {
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
