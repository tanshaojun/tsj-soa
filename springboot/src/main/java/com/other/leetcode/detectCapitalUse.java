package com.other.leetcode;

public class detectCapitalUse {

    public static boolean detectCapitalUse(String word) {

        String s = word.toLowerCase();
        if (s.equals(word)) {
            return true;
        }
        s = s.toUpperCase();
        if (s.equals(word)) {
            return true;
        }
        String substring1 = word.substring(0, 1);
        if (substring1.equals(substring1.toUpperCase())) {
            String substring = word.substring(1);
            s = substring.toLowerCase();
            if (s.equals(substring)) {
                return true;
            }
            s = substring.toUpperCase();
            if (s.equals(substring)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("DxD"));
    }
}
