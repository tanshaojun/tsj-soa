package com.other.t;

import com.other.model.ListNode;
import com.utils.NodeUtil;

import static org.apache.commons.lang3.ArrayUtils.swap;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 14:47
 */
public class TwoPointsSearch {

    public static void main(String[] args) {
//        ListNode listNode = NodeUtil.getListNode(10, 10);
//        ifRing(listNode);
        System.out.println(letterReverse("adcbe"));
    }

    private static String letterReverse(String str) {
        if (null == str) return str;
        char[] strChars = str.toCharArray();
        int leftIndex = 0;
        int rightIndex = strChars.length - 1;

        while (leftIndex < rightIndex) {
            while (!Character.isLetter(strChars[leftIndex])) {
                leftIndex++;
            }
            while (!Character.isLetter(strChars[rightIndex])) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            char tmp = strChars[leftIndex];
            strChars[leftIndex] = strChars[rightIndex];
            strChars[rightIndex] = tmp;
            leftIndex++;
            rightIndex--;
        }
        return new String(strChars);

    }

    private static ListNode ring(ListNode head, ListNode head1) {
        //判断单链表是否有环，有则等于环节点，无等于null
        ListNode a = ifRing(head);
        ListNode b = ifRing(head1);
        ListNode c = null;
        ListNode d = null;
        //此时判断两个无环链表相交
        if (a == null && b == null) {
            c = head;
            int len = 0;
            while (c != null) {
                len++;
                c = c.next;
            }
            d = head1;
            while (d != null) {
                len--;
                d = d.next;
            }
            if (d == c) {
                c = head;
                d = head1;
                if (len > 0) {
                    while (len != 0) {
                        len--;
                        c = c.next;
                    }
                } else {
                    while (len != 0) {
                        len++;
                        d = d.next;
                    }
                }
                while (c != d) {
                    c = c.next;
                    d = d.next;
                }
                return c;
            } else {
                return null;
            }
            //此时判断两个有环链表相交
        } else if (a != null && b != null) {
            //两个链表在没进环就相交
            if (a == b) {
                c = head;
                int len = 0;
                while (c != a) {
                    len++;
                    c = c.next;
                }
                d = head1;
                while (d != a) {
                    len--;
                    d = d.next;
                }
                c = head;
                d = head1;
                if (len > 0) {
                    while (len != 0) {
                        len--;
                        c = c.next;
                    }
                } else {
                    while (len != 0) {
                        len++;
                        d = d.next;
                    }
                }
                while (c != d) {
                    c = c.next;
                    d = d.next;
                }
                return c;
            } else {
                c = a;
                a = a.next;
                while (true) {
                    //两个链表在环内就相交
                    if (a == b) return a;
                    //两个链表不相交
                    if (c == a) return null;
                    a = a.next;
                }
            }
        }
        return null;
    }

    private static ListNode ifRing(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast.next == null || fast.next.next == null) return null;
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private static void partition(ListNode listNode, int value) {
        ListNode head = listNode;
        ListNode less = null;
        ListNode more = null;
        ListNode mid = null;
        while (head != null) {
            int val = head.val;
            if (mid == null && val == value)
                mid = head;
            if (more == null && val > value)
                more = head;
            if (less == null && val < value)
                less = head;
            if (less != null && mid != null && more != null) break;
            head = head.next;
        }
        head = listNode;

        ListNode lessTail = less;
        ListNode moreTail = more;
        ListNode midTail = mid;

        while (head != null) {
            int val = head.val;
            if (mid != head && val == value) {
                midTail.next = head;
                midTail = midTail.next;
            }
            if (more != head && val > value) {
                moreTail.next = head;
                moreTail = moreTail.next;
            }
            if (less != head && val < value) {
                lessTail.next = head;
                lessTail = lessTail.next;
            }
            head = head.next;
        }
        if (more != null) {
            moreTail.next = null;
        }
        if (mid != null) {
            midTail.next = more;
        } else {
            mid = more;
        }
        if (less != null) {
            lessTail.next = mid;
        } else {
            less = mid;
        }
        listNode = less;
    }

    private static void heapSort(int[] array) {
        for (int i = 0; i < array.length; i++)
            heapInsert(array, i);
        int size = array.length;
        swap(array, 0, --size);
        while (size > 0) {
            heapify(array, 0, size);
            swap(array, 0, --size);
        }
    }

    private static int maxInterval(int[] array) {
        int len = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        if (max == min) return 0;

        boolean[] flags = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        for (int i = 0; i < array.length; i++) {
            int b = (array[i] - min) * len / (max - min);
            mins[b] = flags[b] ? Math.min(array[i], mins[b]) : array[i];
            maxs[b] = flags[b] ? Math.max(array[i], maxs[b]) : array[i];
            flags[b] = true;
        }
        int res = 0;
        max = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (flags[i]) {
                res = Math.max(res, mins[i] - max);
                max = maxs[i];
            }
        }
        return res;

    }


    private static void heapify(int[] array, int index, int size) {
        int leftIndex = index * 2 + 1;
        while (leftIndex < size) {
//            int rightIndex = index * 2 + 2;
            int rightIndex = leftIndex + 1;
            int max = rightIndex < size && array[rightIndex] > array[leftIndex] ? rightIndex : leftIndex;
            max = array[index] > array[max] ? index : max;
            if (max == index) break;
            swap(array, max, index);
            index = max;
            leftIndex = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) >> 1]) {
            swap(array, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            swap(array, left + ((right - left) >> 1), right);
            int[] tmp = partition(array, left, right);
            quickSort(array, left, tmp[0]);
            quickSort(array, tmp[1] + 1, right);
        }
    }


    private static int[] partition(int[] array, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (array[left] < array[right]) {
                swap(array, ++less, left++);
            } else if (array[left] > array[right]) {
                swap(array, left, --more);
            } else {
                left++;
            }
        }
        swap(array, more, right);
        return new int[]{less + 1, more};
    }


    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
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
