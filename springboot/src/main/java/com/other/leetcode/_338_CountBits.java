package com.other.leetcode;

/**
 * 338. 比特位计数
 */
public class _338_CountBits {
    public static void main(String[] args) {
        System.out.println(countBits(2));
    }

    public static int[] countBits(int num) {
        int[] ints = new int[num + 1];
        ints[0] = 0;
        for (int i = 1; i <= num; i++) {
            int count = i;
            ints[i] = ints[(count - 1) & count] + 1;
        }
        return ints;
    }
}
