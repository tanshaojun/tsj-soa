package com.demo;

public class peakIndexInMountainArray {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }

    public static int peakIndexInMountainArray(int[] A) {
        int s = 0;
        int e = A.length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) return m;
            if (A[m] < A[m - 1]) e = m - 1;
            if (A[m] < A[m + 1]) s = m + 1;
        }
        return 0;
    }
}
