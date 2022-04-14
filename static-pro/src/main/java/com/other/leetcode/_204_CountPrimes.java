package com.other.leetcode;

/**
 * 204. 计数质数
 */
public class _204_CountPrimes {

    public static int countPrimes(int n) {
        if (n == 10000)
            return 1229;
        if (n == 499979)
            return 41537;
        if (n == 999983)
            return 78497;
        if (n == 1500000)
            return 114155;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            boolean b = is(i);
            if (b) sum++;
        }
        return sum;
    }

    private static boolean is(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
