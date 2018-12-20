package com.other.leetcode;

public class countAndSay {
    public static String countAndSay(int n) {
        StringBuffer sb1 = new StringBuffer("1");
        StringBuffer sb = new StringBuffer("");
        int count = 1;
        aa:
        for (int i = 2; i <= n; i++) {
            char[] chars = sb1.toString().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if ((j + 1) <= chars.length - 1) {
                    if (chars[j] == chars[j + 1]) {
                        count++;
                        if ((j + 1) == chars.length - 1) {
                            sb.append(String.valueOf(count));
                            sb.append(chars[j]);
                            count = 1;
                            sb1 = sb;
                            sb = new StringBuffer("");
                            continue aa;
                        }
                    } else {
                        sb.append(String.valueOf(count));
                        sb.append(chars[j]);
                        count = 1;
                    }
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(chars[j]);
                }
            }
            sb1 = sb;
            sb = new StringBuffer("");
        }
        return sb1.toString();

    }

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
