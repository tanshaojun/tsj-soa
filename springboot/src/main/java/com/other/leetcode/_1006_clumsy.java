package com.other.leetcode;

/**
 * 笨阶乘
 *
 * @Author tansj
 * @Date 2021-04-23 10:25
 * @Version 1.0
 */
public class _1006_clumsy {

    public int clumsy(int N) {
        if (1 == N) {
            return N;
        }
        if (2 == N) {
            return N * (N - 1);
        }
        if (3 == N) {
            return N * (N - 1) / (N - 2);
        }
        if (4 == N) {
            return N * (N - 1) / (N - 2) + (N - 3);
        }
        int sum = 0;
        int count = 0;
        for (int i = N; i >= 4; i -= 4) {
            int a = i;
            int b = i - 1;
            int c = i - 2;
            int d = i - 3;
            if (count == 0) {
                sum += a * b / c + d;
            } else {
                sum -= a * b / c - d;
            }
            count++;
        }
        N = N % 4;
        if (1 == N) {
            return sum - N;
        }
        if (2 == N) {
            return sum - (N * (N - 1));
        }
        if (3 == N) {
            return sum - N * (N - 1) / (N - 2);
        }
        if (4 == N) {
            return sum - N * (N - 1) / (N - 2) + (N - 3);
        }
        return sum;
    }
}
