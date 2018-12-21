package com.other.leetcode;

public class trailingZeroes {

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
