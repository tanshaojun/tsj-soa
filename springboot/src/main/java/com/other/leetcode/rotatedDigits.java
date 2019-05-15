package com.other.leetcode;

public class rotatedDigits {
    public static int rotatedDigits(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (!rotate(String.valueOf(i)) && rotate1(String.valueOf(i))) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(2));
    }

    private static boolean rotate(String i) {
        return i.contains("3") || i.contains("4") || i.contains("7");
    }

    private static boolean rotate1(String i) {
        return i.contains("2") || i.contains("5") || i.contains("6") || i.contains("9");
    }

}
