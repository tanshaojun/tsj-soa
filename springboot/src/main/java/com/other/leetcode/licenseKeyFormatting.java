package com.other.leetcode;


import org.apache.tomcat.jni.LibraryNotFoundError;

public class licenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        String re = "[^a-zA-Z0-9]";
        String re1 = S.replaceAll(re, "").toUpperCase();
        if (K == 0) return re1;
        String s = "";
        int tmp = re1.length();
        for (int i = re1.length() - K; i > 0; i -= K) {
            String ss = re1.substring(i, tmp);
            tmp = i;
            if ("".equals(s)) s = ss;
            else s = ss + "-" + s;
        }
        String ss = re1.substring(0, tmp);
        if ("".equals(s)) s = ss;
        else s = ss + "-" + s;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-5g-3-J", 1));
    }
}
