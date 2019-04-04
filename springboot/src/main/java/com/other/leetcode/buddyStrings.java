package com.other.leetcode;

public class buddyStrings {
    public static boolean buddyStrings(String A, String B) {
        if ("".equals(A) || "".equals(B)) return false;
        if (A.length() != B.length()) return false;
        else {
            boolean rr = false;
            if (A.equals(B)) {
                char[] chars = A.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    String r = "[^" + aChar + "]";
                    String replace = B.replaceAll(r, "");
                    if (replace.length() > 1) rr = true;
                }
                return rr;
            } else {
                int sum = 0;
                char[] achars = A.toCharArray();
                char[] bchars = B.toCharArray();
                char a = achars[0];
                char b = bchars[0];
                for (int i = 0; i < A.length(); i++) {
                    if (achars[i] != bchars[i]) {
                        sum++;
                        if (sum == 1) {
                            a = achars[i];
                            b = bchars[i];
                        }
                    }
                    if (sum == 2) {
                        if (a == bchars[i] && b == achars[i]) rr = true;
                    }
                    if (sum > 2) rr = false;
                }
                return rr;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("aaaaaaabca", "aaaaaaacbc"));
    }
}
