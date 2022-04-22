package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 2181. 合并零之间的节点
 *
 * @Author tansj
 * @Date 2022/4/14 5:36 下午
 * @Version 1.0
 */
public class _2181_mergeNodes {

    public ListNode mergeNodes(ListNode head) {
        while (head != null && head.val == 0) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int val = cur.next.val;
            if (val > 0) {
                cur.val += val;
                cur.next = cur.next.next;
            } else {
                cur.next = cur.next.next;
                while (cur.next != null && cur.next.val == 0) {
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }

}
