package com.other.leetcode;

public class fib {
    public static int fib1(int N) {
        if (0 == N) return 0;
        if (1 == N) return 1;
        int[] ints = new int[N + 1];
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++)
            ints[i] = ints[i - 1] + ints[i - 2];
        return ints[N];
    }

    public static int fib(int N) {
        if (0 == N) return 0;
        if (1 == N) return 1;
        int a = 0;
        int b = 1;
        int sum = 0;

        for (int i = 2; i <= N; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
