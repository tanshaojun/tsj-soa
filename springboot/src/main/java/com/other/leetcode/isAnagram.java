package com.other.leetcode;

import java.util.Arrays;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chart = t.toCharArray();
        Arrays.sort(chart);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chart[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
