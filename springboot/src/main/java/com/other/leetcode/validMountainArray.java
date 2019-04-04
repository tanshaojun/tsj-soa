package com.other.leetcode;

public class validMountainArray {
    // 1 2 3 2 1
    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        boolean b = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            } else if (A[i] > A[i - 1] && b) {
                return false;
            } else if (A[i] < A[i - 1]) {
                if (i == 1) return b;
                b = true;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{1, 3, 2}));
    }


}
