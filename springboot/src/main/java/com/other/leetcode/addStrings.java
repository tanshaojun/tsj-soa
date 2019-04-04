package com.other.leetcode;

public class addStrings {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer("");
        if (num1.length() < num2.length()) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int num1length = num1.length() - 1;
        int num2length = num2.length() - 1;

        int i = num1length - num2length;

        int j = 0;
        int count = num2length;
        while (count >= 0) {
            int num = get(num1.charAt(count + i)) + get(num2.charAt(count)) + j;
            j = getJ(sb, num);
            count--;
        }
        i--;
        while (count < i) {
            int num = get(num1.charAt(i)) + j;
            j = getJ(sb, num);
            i--;
        }
        if (j != 0) {
            sb.append(j);
        }
        return sb.reverse().toString();
    }

    private int getJ(StringBuffer sb, int num) {
        int j;
        if (num < 10) {
            j = 0;
            sb.append(num);
        } else {
            j = num / 10;
            sb.append(num % 10);
        }
        return j;
    }

    public int get(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }
}
