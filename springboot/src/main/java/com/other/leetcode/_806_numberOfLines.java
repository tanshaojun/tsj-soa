package com.other.leetcode;

/**
 * 806. 写字符串需要的行数
 */
public class _806_numberOfLines {
    public static int[] numberOfLines(int[] widths, String S) {
        int sum = 0;
        int a = 1;
        int b = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            int i = 100 - sum;
            int width = widths[c - 'a'];
            if (i >= width) {
                sum += widths[c - 'a'];
            } else {
                a++;
                sum = width;
            }
        }
        b = sum;
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] ints = numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "c");
        System.out.println(ints);
    }
}
