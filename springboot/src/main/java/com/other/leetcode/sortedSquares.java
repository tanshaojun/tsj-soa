package com.other.leetcode;

import java.util.Arrays;

public class sortedSquares {
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] = A[i] * A[i];
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {

        int[] ints = sortedSquares(new int[]{-7,-3,2,3,11,10000});
        System.out.println(ints);
    }
}




