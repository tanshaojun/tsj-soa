package com.other.leetcode;

public class compress {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int num = 1;
        int i = 0;
        int j = 1;
        while (j <= chars.length) {
            if (j < chars.length && chars[j - 1] == chars[j]) {
                num++;
            } else if (j == chars.length || j < chars.length && chars[j - 1] != chars[j]) {
                chars[i++] = chars[j - 1];
                if (num == 1) {
                    j++;
                    continue;
                }
                if (num < 10) {
                    chars[i++] = Integer.toString(num).charAt(0);
                } else {
                    char[] ch1 = Integer.toString(num).toCharArray();
                    for (char c : ch1) {
                        chars[i++] = c;
                    }
                }
                num = 1;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println((char) ('1' + 1));
    }
}
