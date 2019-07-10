package com.other.leetcode;

/**
 * 66. 加一
 */
public class _66_PlusOne {
    public static int[] plusOne(int[] digits) {
        String s = "";
        int count = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int i1 = digits[i] + count;
            if (i1 == 10) {
                count = 1;
                if (i == 0) s += "01";
                else s += "0";
            } else {
                count = 0;
                s += "" + i1;
            }
        }
        int[] ints = new int[s.length()];
        int c = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char cc = s.charAt(i);
            ints[c++] = Integer.valueOf(String.valueOf(cc));
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9, 9, 9, 9, 9, 9}));
    }
}
