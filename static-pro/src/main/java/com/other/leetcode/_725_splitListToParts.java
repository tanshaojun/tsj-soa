package com.other.leetcode;

import com.other.model.ListNode;
import com.utils.NodeUtil;

/**
 * 725. 分隔链表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 11:12
 */
public class _725_splitListToParts {
    public static void main(String[] args) {
        ListNode[] listNodes = splitListToParts(NodeUtil.getListNode(10, 10), 3);
        System.out.println();
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        if (k == 1) return new ListNode[]{root};
        ListNode cur = root;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode[] listNodes = new ListNode[k];
        cur = root;
        int index = 0;
        if (k > len) {
            while (len != index) {
                ListNode next = cur.next;
                listNodes[index] = cur;
                listNodes[index].next = null;
                cur = next;
                index++;
            }
            return listNodes;
        }

        int s = len / k;
        int y = len % k;
        ListNode tmp = cur;
        len = s;
        while (k != 1) {
            if (y > 0) {
                y--;
                len++;
            }
            while (len != 1) {
                len--;
                tmp = tmp.next;
            }
            ListNode next = tmp.next;
            tmp.next = null;
            listNodes[index++] = cur;
            cur = next;
            tmp = cur;
            len = s;
            k--;
        }
        listNodes[index++] = cur;
        return listNodes;
    }
}
