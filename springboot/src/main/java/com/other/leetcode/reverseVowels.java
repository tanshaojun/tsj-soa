package com.other.leetcode;

public class reverseVowels {
    public static String reverseVowels(String s) {
        if ("".equals(s)) return s;
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            char lChar = chars[l];
            char rChar = chars[r];
            boolean lb = is(lChar);
            boolean rb = is(rChar);
            if (!lb) l++;
            if (!rb) r--;
            if (lb && rb) {
                if (lChar != rChar) {
                    chars[l] = rChar;
                    chars[r] = lChar;
                }
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels(""));
    }

    private static boolean is(char c) {
        switch (c) {
            case 'a':
                return true;
            case 'A':
                return true;
            case 'e':
                return true;
            case 'E':
                return true;
            case 'i':
                return true;
            case 'I':
                return true;
            case 'o':
                return true;
            case 'O':
                return true;
            case 'u':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
