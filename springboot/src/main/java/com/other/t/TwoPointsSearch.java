package com.other.t;

import com.other.leetcode.ListNode;
import com.other.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 14:47
 */
public class TwoPointsSearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(array, 5));
        ListNode listNode = ListNode.getListNode(5);
        reverse(listNode);
    }

    /**
     * 反转链表
     *
     * @param heade
     * @return
     */
    private static ListNode reverse(ListNode heade) {
        ListNode r = null;
        ListNode tmp;
        while (heade != null) {
            tmp = heade.next;
            heade.next = r;
            r = heade;
            heade = tmp;
        }
        return r;
    }

    /**
     * 二分查找
     *
     * @param array
     * @param num
     * @return
     */
    private static int search(int[] array, int num) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (array[m] > num) r = m - 1;
            else if (array[m] < num) l = m + 1;
            else return m;
        }
        return -1;
    }
}
