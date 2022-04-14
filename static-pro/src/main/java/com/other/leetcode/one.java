package com.other.leetcode;

public class one {
    public static void main(String[] args) {
        int n = 217;
        System.out.println(binary1num(22));
    }

    static int binary0num(int x) {
        int num = 0;
        while ((x + 1) != 0) {
            x = x | (x + 1);
            num++;
        }
        return num;
    }

    static int binary1num(int x) {
        int num = 0;
        while (x != 0) {
            x = x & (x - 1);
            num++;
        }

        return num;
    }


}

