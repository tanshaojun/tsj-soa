package com.other.offer;


import com.other.model.ListNode;

public class M52 {


    /**
     * 两个链表的第一个公共节点
     * <p>
     * 先计算两个链表的长度，让长的链表先走两个链表的差值，然后一起走，比较相等
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode l1, ListNode l2) {
        if (null == l1 || null == l2) return null;
        int size1 = 0;

        ListNode head = l1;
        while (head != null) {
            size1++;
            head = head.next;
        }

        head = l2;
        int size2 = 0;
        while (head != null) {
            size2++;
            head = head.next;
        }

        if (size1 > size2) {
            int diff = size1 - size2;
            while (diff > 0) {
                diff--;
                l1 = l1.next;
            }
        } else {
            int diff = size2 - size1;
            while (diff > 0) {
                diff--;
                l2 = l2.next;
            }
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }


}
