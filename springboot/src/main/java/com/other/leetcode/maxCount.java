package com.other.leetcode;

public class maxCount {
    public static int maxCount(int m, int n, int[][] ops) {
        int a = m;
        int b = n;
        for (int i = 0; i < ops.length; i++) {
            int[] op = ops[i];
            a = op[0] >= a ? a : op[0];
            b = op[1] >= b ? b : op[1];
        }
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][]{}));
    }
}
