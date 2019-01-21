package com.other.leetcode;

public class reverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        if (S.length() == 0) return S;
        int l = 0;
        int r = S.length() - 1;
        char[] chars = S.toCharArray();
        while (l < r) {
            char lc = chars[l];
            char rc = chars[r];
            if (((lc >= 97 && lc <= 122) || (lc >= 65 && lc <= 90)) && ((rc >= 97 && rc <= 122) || (rc >= 65 && rc <=
                    90))) {
                char tmp = lc;
                chars[l] = rc;
                chars[r] = tmp;
                l++;
                r--;
            } else {
                if (!((lc >= 97 && lc <= 122) || (lc >= 65 && lc <= 90))) l++;
                if (!((rc >= 97 && rc <= 122) || (rc >= 65 && rc <= 90))) r--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab"));
    }

}
