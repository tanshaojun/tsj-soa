package com.other.leetcode;

public class checkPerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        int mid = (int) Math.sqrt(num);

        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
