package com.other.leetcode;

import com.other.model.ListNode;
import com.utils.NodeUtil;

/**
 * 1019 链表中的下一个更大节点
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/18 9:51
 */
public class _1019_NextLargerNodes {
    public static int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] tmp = new int[size];
        if (size <= 1) return tmp;
        cur = head;
        for (int i = 0; i < size; i++) {
            tmp[i] = cur.val;
            cur = cur.next;
        }
        int[] ints = new int[tmp.length];
        int next = tmp[tmp.length - 1];
        for (int i = tmp.length - 2; i >= 0; i--) {
            int t = tmp[i];
            if (t < next) {
                ints[i] = next;
            } else {
                for (int j = i + 1; j < tmp.length; j++) {
                    if (tmp[j] > t) {
                        ints[i] = tmp[j];
                        break;
                    }
                }
            }
            next = t;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = nextLargerNodes(NodeUtil.getListNode(3,10));
        System.out.println();
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            System.out.print("  ");
        }

    }
}
