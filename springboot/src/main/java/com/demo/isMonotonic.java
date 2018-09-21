package com.demo;

public class isMonotonic {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,1,1}));

    }

    public static boolean isMonotonic(int[] A) {
        int a = 0;
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) < A.length) {
                if (A[i] < A[i + 1]) {
                    if (a == 0) a = 1;
                    if (a == 2) return false;
                }
                if (A[i] > A[i + 1]) {
                    if (a == 0) a = 2;
                    if (a == 1) return false;

                }
            }
        }
        return true;

    }
}

