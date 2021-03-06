package com.other.leetcode;

import java.util.Arrays;

/**
 * 961. 重复 N 次的元素
 */
public class _961_repeatedNTimes {
    public static int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        return A[A.length/2]==A[A.length-1]?A[A.length/2]:A[A.length/2-1];
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{9, 5, 3, 3}));
    }

}
