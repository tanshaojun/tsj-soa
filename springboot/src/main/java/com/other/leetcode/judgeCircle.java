package com.other.leetcode;

public class judgeCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UDU"));

    }

    public static boolean judgeCircle(String moves) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U')
                a++;
            if (c == 'D')
                a--;
            if (c == 'L')
                b++;
            if (c == 'R')
                b--;
        }
        return a == 0 && b == 0;
    }
}
