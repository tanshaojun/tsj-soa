package com.other.leetcode;

import java.util.Arrays;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 17:10
 */
public class _1030_allCellsDistOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[] t = new int[R * C];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[index][0] = i;
                res[index][1] = j;
                t[index] = Math.abs(i - r0) + Math.abs(j - c0);
                index++;
            }
        }
        Arrays.sort(res,
                (a, b) -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0)));
//        quickSort(res, t, 0, t.length - 1);
        return res;
    }

    private void quickSort(int[][] res, int[] t, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            swap(t, mid, right);
            swap(res, mid, right);
            int[] m = partition(res, t, left, right);
            quickSort(res, t, left, m[0] - 1);
            quickSort(res, t, m[0] + 1, right);
        }
    }

    private int[] partition(int[][] res, int[] t, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (t[left] > t[right]) {
                more--;
                swap(t, more, left);
                swap(res, more, left);
            } else if (t[left] < t[right]) {
                less++;
                swap(t, left, less);
                swap(res, left, less);
                left++;
            } else {
                left++;
            }
        }
        swap(t, more, right);
        swap(res, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] t, int left, int right) {
        int tmp = t[left];
        t[left] = t[right];
        t[right] = tmp;
    }

    private void swap(int[][] t, int left, int right) {
        int tmp = t[left][0];
        t[left][0] = t[right][0];
        t[right][0] = tmp;

        tmp = t[left][1];
        t[left][1] = t[right][1];
        t[right][1] = tmp;
    }

}
