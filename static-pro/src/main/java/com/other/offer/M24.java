package com.other.offer;

import com.other.model.ListNode;

public class M24 {


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseListNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            //保存当前节点的下一个节点
            ListNode next = cur.next;
            //将当前节点设置为头节点
            cur.next = res;
            res = cur;
            //将下一个节点赋值给当前节点
            cur = next;
        }
        return res;
    }


}
