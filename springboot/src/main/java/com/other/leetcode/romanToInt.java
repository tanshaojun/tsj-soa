package com.other.leetcode;


public class romanToInt {

    public static int romanToInt(String s) {
        if ("IV".equals(s)) {
            return 4;
        }
        if ("IX".equals(s)) {
            return 9;
        }
        if ("XL".equals(s)) {
            return 40;
        }

        if ("XC".equals(s)) {
            return 90;
        }

        if ("CD".equals(s)) {
            return 400;
        }

        if ("CM".equals(s)) {
            return 900;
        }
        int sum = 0;
        int tmp = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int a = data(c);
            if (tmp >= a) {
                tmp = a;
                sum += tmp;
            } else {
                tmp = a - 2 * tmp;
                sum += tmp;
                tmp = a;
            }
        }
        return sum;
    }

    private static Integer data(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }


}
