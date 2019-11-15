package com.other.leetcode;

/**
 * 650. 只有两个键的键盘
 */
public class _650_MinSteps {
    public static void main(String[] args) {
        System.out.println(minSteps(8));
    }

    public static int minSteps(int n) {
        if (n == 1) return 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                n = n / i;
            }
        }
        return sum;
    }
}
