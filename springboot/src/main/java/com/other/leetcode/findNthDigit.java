package com.other.leetcode;

public class findNthDigit {
    public static int findNthDigit(int n) {
        long len = 1, cnt = 9, start = 1;
        while (n > len * cnt) {
            n -= len * cnt;
            ++len;
            cnt *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        char[] t = String.valueOf(start).toCharArray();
        int l = (int) ((int) (n - 1) % len);
        return t[l]-'0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(2147483647));
    }
}
