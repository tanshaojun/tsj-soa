package com.other.leetcode;

/**
 * 922. 按奇偶排序数组 II
 */
public class _922_sortArrayByParityII {
    public static void main(String[] args) {
        System.out.println(sortArrayByParityII(new int[]{4, 2, 5, 7}));

    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] ints = new int[A.length];
        int a = 0;
        int b = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ints[a] = A[i];
                a += 2;
            } else {
                ints[b] = A[i];
                b += 2;
            }
        }
        return ints;
    }
}
