package com.other.leetcode;

/**
 * 707. 设计链表
 */
class _707_MyLinkedList {

    N head;
    int length;

    /**
     * Initialize your data structure here.
     */
    public _707_MyLinkedList() {
        length = 0;
        head = new N(-1);
    }

    /**
     * Get the value of the index-th N in the linked res. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= length || index < 0)
            return -1;
        N current = head;
        for (int i = 0; i <= index; i++)
            current = current.next;
        return current.value;
    }

    /**
     * Add a N of value val before the first element of the linked res. After the insertion, the new N will be
     * the first N of the linked res.
     */
    public void addAtHead(int val) {
        N temp = new N(val);
        temp.next = head.next;
        head.next = temp;
        length++;
    }

    /**
     * Append a N of value val to the last element of the linked res.
     */
    public void addAtTail(int val) {
        N current = head;
        while (current.next != null)
            current = current.next;
        N temp = new N(val);
        current.next = temp;
        length++;
    }

    /**
     * Add a N of value val before the index-th N in the linked res. If index equals to the length of linked
     * res, the N will be appended to the end of linked res. If index is greater than the length, the N will
     * not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        if (index == length) {
            addAtTail(val);
            return;
        }
        if (index < 0)
            index = index + length + 1;
        N current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        N ptr = current.next;
        N temp = new N(val);
        current.next = temp;
        temp.next = ptr;
        length++;
    }

    /**
     * Delete the index-th N in the linked res, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0)
            return;
        N current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        current.next = current.next.next;
        length--;
    }
}

class N {
    int value;
    N next;

    public N(int value) {
        this.value = value;
    }
}


