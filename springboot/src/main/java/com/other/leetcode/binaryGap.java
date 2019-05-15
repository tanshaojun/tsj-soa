package com.other.leetcode;

public class binaryGap {
    public static int binaryGap(int N) {
        int count = -1;
        int max = -1;
        int a = 0;
        while (N != 0) {
            count++;
            if ((N & 1) == 1) {
                if ((count - a) > max) max = max == -1 ? 0 : count - a;
                a = count;
            }
            N = N >> 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
