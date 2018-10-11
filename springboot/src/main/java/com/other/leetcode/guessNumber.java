package com.other.leetcode;

public class guessNumber {
    public static int guessNumber(int n) {
        return aaa(0, n);
    }

    int a = 6;

    private static int aaa(int i, int n) {
        int mid = i + ((n - i) >> 1);
        if (guess(mid) == 1) {
            return aaa(0, mid - 1);
        } else if (guess(mid) == -1) {
            return aaa(mid + 1, n);
        }
        return mid;
    }

    static int guess(int num) {
        if (num > 6) {
            return 1;
        } else if (num < 6) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
