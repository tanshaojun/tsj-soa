package com.other.leetcode;

public class flipAndInvertImage {

    public static int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int[] ints = A[i];
            int l = 0;
            int r = ints.length - 1;
            while (l <= r) {
                int tem = ints[l] == 0 ? 1 : 0;
                ints[l] = ints[r] == 0 ? 1 : 0;
                ints[r] = tem;
                l++;
                r--;
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[][] ints = flipAndInvertImage(new int[][]{{1}, {1}, {1}});
        System.out.println(ints);
    }
}
