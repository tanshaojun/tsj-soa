package com.other.leetcode;

/**
 * 56. 合并区间
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 15:05
 */
public class _56_merge {

    public static void main(String[] args) {
        merge(new int[][]{{1, 4}, {2, 4}, {0, 0}});
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        int length = intervals.length;
        int[] ints = new int[length * 2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            ints[index++] = intervals[i][0];
            ints[index++] = intervals[i][1];
        }
        mergeSort(ints, 0, length - 1);
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (ints[2 * i - 1] >= ints[2 * i + 1]) {
                ints[2 * i + 1] = ints[2 * i - 1];
                ints[2 * i - 1] = -1;
                ints[2 * i] = -1;
            } else {
                if (ints[2 * i - 1] >= ints[2 * i]) {
                    ints[2 * i - 1] = -1;
                    ints[2 * i] = -1;
                }
            }
            if (ints[2 * i] != -1) {
                count++;
            }
        }
        int[][] res = new int[count][2];
        count = 0;
        for (int i = 0; i < res.length; i++) {
            int tmp = 0;
            while (tmp != 2 && count < ints.length) {
                if (ints[count] != -1) {
                    res[i][tmp++] = ints[count];
                }
                count++;
            }
        }
        return res;
    }

    private static void mergeSort(int[] ints, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(ints, left, mid);
            mergeSort(ints, mid + 1, right);
            merge(ints, left, mid, right);
        }
    }

    public static void merge(int[] ints, int left, int mid, int right) {
        int[] tmp = new int[(right - left + 1) * 2];
        int index = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            int t;
            if (ints[l * 2] < ints[r * 2]) {
                t = l * 2;
                l++;
            } else {
                t = r * 2;
                r++;
            }
            tmp[index++] = ints[t];
            tmp[index++] = ints[t + 1];
        }
        while (l <= mid) {
            tmp[index++] = ints[l * 2];
            tmp[index++] = ints[l * 2 + 1];
            l++;
        }
        while (r <= right) {
            tmp[index++] = ints[r * 2];
            tmp[index++] = ints[r * 2 + 1];
            r++;
        }
        for (int i = 0; i < tmp.length; i++)
            ints[left * 2 + i] = tmp[i];
    }

}
