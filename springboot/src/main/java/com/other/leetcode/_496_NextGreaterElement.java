package com.other.leetcode;

/**
 * 496. 下一个更大元素 I
 */
public class _496_NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            int tmp = nums1[i];
            nums1[i] = -1;
            boolean flag = false;
            for (int j = 0; j <= len; j++) {
                if (tmp == nums2[j]) {
                    flag = true;
                }
                if (flag) {
                    if (tmp < nums2[j]) {
                        nums1[i] = nums2[j];
                        break;
                    }
                }
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});

    }
}
