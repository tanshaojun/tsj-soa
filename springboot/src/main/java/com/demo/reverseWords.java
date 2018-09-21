package com.demo;

public class reverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("1 "));
    }

    public static String reverseWords(String s) {
        if ("".equals(s)) return s;
        StringBuffer sb = new StringBuffer("");
        String[] split = s.trim().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!"".equals(split[i])) {
                sb.append(split[i]);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
