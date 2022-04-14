package com.other.offer;

import com.other.model.ListNode;

public class M22 {


    /**
     * 链表中倒数第K个节点
     * <p>
     * 遍历二次的方法：先遍历一次计算链表的长度len，在遍历一次找到len-k
     * 遍历一次的方法：设置快慢两个指针，让快指针先走k步，然后慢指针从头开始，同时向前走，最后快指针为空时，慢指针就是目标节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (null == head || 0 == k) {
            return null;
        }
        ListNode fast = head;
        while (k > 0 && fast != null) {
            k--;
            fast = fast.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
