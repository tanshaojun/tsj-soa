package com.other.leetcode;

import com.other.model.ListNode;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/2 10:09
 */
public class _1171_removeZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        ListNode tmp = cur.next;
        while (null != cur.next) {
            int sum = 0;
            while (null != tmp) {
                sum += tmp.val;
                if (0 == sum) break;
                tmp = tmp.next;
            }
            if (0 == sum) {
                tmp = tmp.next;
                cur.next = tmp;
            } else {
                cur = cur.next;
                tmp = cur.next;
            }
        }
        return dummy.next;
    }
}
