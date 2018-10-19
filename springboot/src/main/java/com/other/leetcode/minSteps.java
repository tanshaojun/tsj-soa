package com.other.leetcode;

public class minSteps {
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
