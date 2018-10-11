package com.other.leetcode;

public class toLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("&&&"));
    }

    public static String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 97 && c >= 65) sb.append((char) (c + 32));
            else sb.append(c);
        }
        return sb.toString();

    }
}
