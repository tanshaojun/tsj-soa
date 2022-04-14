package com.other.leetcode;

public class ClimbLadder {
    public static   void main(String[] args) {
        System.out.println(climb(10));
    }

    public static   Integer climb(Integer n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        int tem = 0;
        for (int i = 2; i < n; i++) {
            tem = a + b;
            a = b;
            b = tem;
        }
        return tem;
    }
}
