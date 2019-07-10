package com.other.leetcode;

/**
 * 88. 合并两个有序数组
 */
public class _88_Merge {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        int t = 0;
        int[] tem = new int[m + n];
        while (b < n && a < m) {
            if (nums1[a] > nums2[b]) tem[t++] = nums2[b++];
            else tem[t++] = nums1[a++];
        }
        while (a < m) tem[t++] = nums1[a++];
        while (b < n) tem[t++] = nums2[b++];
        for (int i = 0; i < tem.length; i++)
            nums1[i] = tem[i];
    }
}
