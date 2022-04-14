package com.other.leetcode;

/**
 * 667. 优美的排列 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 11:00
 */
public class _667_constructArray {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++)
            res[i] = i + 1;
        int count = 1;
        while (count < k) {
            int start = count;
            int end = n - 1;
            while (start < end) {
                int tmp = res[start];
                res[start] = res[end];
                res[end] = tmp;
                start++;
                end--;
            }
            count++;
        }
        return res;
    }
}
