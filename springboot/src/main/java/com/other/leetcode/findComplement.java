package com.other.leetcode;

public class findComplement {
    public static int findComplement(int num) {
        StringBuffer sb = new StringBuffer("");
        while (num != 0) {
            int i = num / 2;
            int j = num % 2;
            num = i;
            sb.append(j == 0 ? 1 : 0);
        }
        int count = 0;
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '1') {
                if (i == 0) {
                    count++;
                } else {
                    int a = 2;
                    int b = 1;
                    while (b < i) {
                        a *= 2;
                        b++;
                    }
                    count += a;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
