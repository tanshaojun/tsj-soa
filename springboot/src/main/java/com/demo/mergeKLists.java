package com.demo;

public class mergeKLists {
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
        ListNode listNode = null;
        while (start != null && end != null) {
            int a = start.val;
            int b = end.val;
            if (a > b) {
                listNode = addListNode(listNode, b);
                end = end.next;
            } else {
                listNode = addListNode(listNode, a);
                start = start.next;
            }
        }
        while (start != null) {
            listNode = addListNode(listNode, start.val);
            start = start.next;
        }
        while (end != null) {
            listNode = addListNode(listNode, end.val);
            end = end.next;
        }
        return listNode;
    }

    private static ListNode addListNode(ListNode listNode, int b) {
        if (listNode == null) listNode = new ListNode(b);
        else {
            ListNode listNodeb = new ListNode(b);
            ListNode temp = listNode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNodeb;
        }
        return listNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
