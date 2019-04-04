package com.other.leetcode;

public class isPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
}
