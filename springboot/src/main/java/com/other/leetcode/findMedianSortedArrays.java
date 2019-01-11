package com.other.leetcode;

public class findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] ints = new double[nums1.length + nums2.length];
        int a = 0;
        int b = 0;
        int count = 0;
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] < nums2[b]) ints[count++] = nums1[a++];
            else ints[count++] = nums2[b++];
        }
        while (a < nums1.length) ints[count++] = nums1[a++];
        while (b < nums2.length) ints[count++] = nums2[b++];
        if (count % 2 != 0) return ints[count / 2];
        int i = count / 2;
        return (ints[i] + ints[i - 1]) / 2;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

    }
}
