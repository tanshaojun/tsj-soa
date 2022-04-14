package com.other.leetcode;

/**
 * 231. 2的幂
 */
public class _231_IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(2&0x66666666);
    }
}
