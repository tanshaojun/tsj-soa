package com.other.leetcode;

public class MyLinkedList {

    private int val;
    private MyLinkedList next;
    private int count = -1;

    private MyLinkedList first = null;
    private MyLinkedList last = null;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index <= count) {
            int i = 0;
            MyLinkedList linkedList = first;
            while (linkedList != null) {
                if (i == index) return linkedList.count;
                linkedList = linkedList.next;
                i++;
            }
            return linkedList.count;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be
     * the first node of the linked list.
     */
    public void addAtHead(int val) {
        count++;
        if (first == null) {
            first = new MyLinkedList();
            first.count = val;
            first.next = null;
            last = first;
        } else {
            MyLinkedList t = new MyLinkedList();
            t.next = first;
            t.count = val;
            first = t;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        count++;
        if (first == null) {
            first = new MyLinkedList();
            first.count = val;
            first.next = null;
            last = first;
        } else {
            MyLinkedList m = new MyLinkedList();
            m.count = val;
            m.next = null;
            last.next = m;
            last = last.next;

        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
     * not be inserted.
     */
    public void addAtIndex(int index, int val) {

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index > 0 && index < count) {
            count--;
            int i = 0;
            MyLinkedList h = first;
            while (h != null) {
                if (index == i) {
                    if (index == 0) {
                        first = first.next;
                        if (first == null) {
                            last = null;
                        }
                    }
                    h.next = h.next.next;
                }
                i++;
                h = h.next;
            }
        }
    }
}
