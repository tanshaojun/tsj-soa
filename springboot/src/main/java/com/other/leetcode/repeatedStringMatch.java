package com.other.leetcode;

public class repeatedStringMatch {
    public static int repeatedStringMatch(String A, String B) {
        String s = B.replaceAll(A, "");
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aaaa", "aaaa"));

    }
}
