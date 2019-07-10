package com.other.leetcode;

/**
 * 172. 阶乘后的零
 */
public class _172_TrailingZeroes {

    static int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(200));
    }
}
