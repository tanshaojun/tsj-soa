package com.other.leetcode;

/**
 * 9. 回文数
 */
public class _9_IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l <= r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }

    public static boolean isPalindrome(ListNode head) {
        if (null == head) return true;
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针找到重点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //从慢指针指向开始，反转
        fast = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = fast;
            fast = slow;
            slow = tmp;
        }
        //比较
        while (fast != null) {
            if (fast.val != head.val) return false;
            fast = fast.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.next = new ListNode(2);
//        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(1);
//        root.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(root));
    }
}
