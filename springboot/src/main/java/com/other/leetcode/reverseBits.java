package com.other.leetcode;

public class reverseBits {
    public static int reverseBits(int n) {
        int r = 0;
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) r |= (1 << (31 - count));
            n = n >>> 1;
            count++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(1));
    }
}
