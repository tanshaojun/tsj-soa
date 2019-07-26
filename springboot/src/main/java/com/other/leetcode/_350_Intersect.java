package com.other.leetcode;

import com.utils.ArrayUtil;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/7/22 14:05
 */
public class _350_Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null) return nums1;
        if (nums2 == null) return nums2;
        if (nums1.length == 0) return nums1;
        if (nums2.length == 0) return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = 0;
        int len2 = len;
        int[] tmp = new int[nums2.length];
        int size = 0;
        while (len < nums1.length && len2 < nums2.length) {
            if (nums1[len] == nums2[len2]) {
                tmp[size++] = nums1[len];
                len++;
                len2++;
            } else if (nums1[len] > nums2[len2]) {
                len2++;
            } else {
                len++;
            }
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = ArrayUtil.generateRandomArray(10, 10);
        System.out.println();
        int[] nums2 = ArrayUtil.generateRandomArray(10, 10);
        System.out.println();
        int[] intersect = intersect(nums1, nums2);

    }

}
