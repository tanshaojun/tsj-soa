package com.other.leetcode;

/**
 * 1806. 还原排列的最少操作步数
 *
 * @Author tansj
 * @Date 2021-05-11 13:10
 * @Version 1.0
 */
public class _1806_reinitializePermutation {

    public int reinitializePermutation(int n) {
        int res = 0;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        while (true) {
            int count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
                if (arr[i] == i) {
                    count++;
                }
            }
            for (int i = 0; i < n; i++) {
                perm[i] = arr[i];
                System.out.print(perm[i]);
                System.out.print(",");
            }
            System.out.println();
            res++;
            if (count == n) {
                return res;
            }
        }
    }

}
