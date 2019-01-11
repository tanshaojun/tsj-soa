package com.other.leetcode;

public class addDigits {
    public static int addDigits(int num) {
        int sum = 0;
        while (true) {
            int i = num / 10;
            sum += i;
            num = num % 10;
            if (num < 10) {
                num = sum + num;
                if (num < 10 && sum < 10) return num;
                sum = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addDigits(0));
    }
}
