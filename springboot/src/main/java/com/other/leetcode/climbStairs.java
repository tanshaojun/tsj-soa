package com.other.leetcode;

public class climbStairs {
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
