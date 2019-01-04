package com.other.leetcode;

public class hammingWeight {

    public static int hammingWeight(int n) {
        int sum = 0;
//        int tmp = n;
//        if (n < 0) n = (0 - n) - 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum++;
            }
            n = n >>> 1;
//            n = n >> 1;
        }
//        return tmp >= 0 ? sum : 32 - sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(0));
    }
}
