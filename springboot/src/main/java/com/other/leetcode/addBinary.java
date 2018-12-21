package com.other.leetcode;

public class addBinary {
    public static String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int m = a.length() - b.length();
        int count = 0;
        StringBuffer sb = new StringBuffer("");
        for (int i = b.length() - 1; i >= 0; i--) {
            char a1 = a.charAt(i + m);
            char b1 = b.charAt(i);
            if (a1 != b1) {
                if (count == 0) {
                    sb.append("1");
                } else {
                    sb.append(String.valueOf(0));
                }
            } else {
                if (a1 == '0') {
                    if (count == 0) {
                        sb.append("0");
                    } else {
                        sb.append(String.valueOf(count));
                        count = 0;
                    }
                } else {
                    if (count == 0) {
                        sb.append("0");
                    } else {
                        sb.append("1");
                    }
                    count = 1;
                }
            }
        }
        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            char a1 = a.charAt(i);
            if (a1 == '0') {
                if (count == 0) {
                    sb.append("0");
                } else {
                    sb.append(String.valueOf(count));
                    count = 0;
                }
            } else {
                if (count == 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        }
        if (count == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addBinary("111", "111"));
    }
}
