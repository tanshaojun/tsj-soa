package com.other.leetcode;

public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (s == null || "".equals(s)) {
                return "";
            }
            if (strs[i] == null || "".equals(strs[i])) {
                return "";
            } else {
                StringBuffer sb = new StringBuffer("");
                String s1 = s.length() > strs[i].length() ? strs[i] : s;
                for (int j = 0; j < s1.length(); j++) {
                    if (s.charAt(j) == strs[i].charAt(j)) {
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }
                }
                s = sb.toString();
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca", "cba"}));

    }
}
