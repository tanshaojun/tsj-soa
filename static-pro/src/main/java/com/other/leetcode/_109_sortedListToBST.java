package com.other.leetcode;

import com.other.model.ListNode;
import com.other.model.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/18 9:54
 */
public class _109_sortedListToBST {

    public TreeNode sortedListToBST1(ListNode head) {
        return sortedListToBST(head, 0);
    }

    public TreeNode sortedListToBST(ListNode head, int t) {
        if (null == head) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == dummy) {
            TreeNode root = new TreeNode(head.val);
            if (head.next != null) {
                if (t > 1) {
                    root.left = new TreeNode(head.next.val);
                } else {
                    root.right = new TreeNode(head.next.val);
                }
            }
            return root;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode mid_next = mid.next;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head, -1);
        root.right = sortedListToBST(mid_next, 1);
        return root;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null;
        if (null == head.next) return new TreeNode(head.val);
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }


}
