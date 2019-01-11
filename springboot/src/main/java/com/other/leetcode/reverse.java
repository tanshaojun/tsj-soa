package com.other.leetcode;

public class reverse {
    public static int reverse(int x) {
        try {
            if (x >= 0) {
                String s = new StringBuffer(String.valueOf(x)).reverse().toString();
                System.out.println(s);
                return Integer.valueOf(s);
            } else {
                return -Integer.valueOf(new StringBuffer(String.valueOf(-x)).reverse().toString());
            }
        } catch (Throwable t) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(113));
    }
}
