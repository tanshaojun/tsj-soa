package com.other.offer;

import com.other.model.ListNode;

public class M23 {

    /**
     * 链表中环的入口节点
     * 1->2->3->4->5->6->3
     * 设置快慢两个指针，从头节点开始出发，快指针每次走两步，慢指针每次走一步，直到相遇或者快指针到空节点退出。
     * 然后设置快指针为头节点，和慢指针每次走一步，相遇即环的入口
     *
     * @param head
     * @return
     */
    public ListNode meetingNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
