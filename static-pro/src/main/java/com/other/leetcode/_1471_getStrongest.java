package com.other.leetcode;

import java.util.Arrays;

/**
 * 1471. 数组中的 k 个最强值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/16 13:38
 */
public class _1471_getStrongest {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(len - 1) / 2];
        int[] res = new int[k];
        int i = 0;
        int left = 0;
        int right = len - 1;
        while (k-- > 0) {
            int l = Math.abs(arr[left] - m);
            int r = Math.abs(arr[right] - m);
            if (l > r) {
                res[i++] = arr[left];
                left++;
            } else {
                res[i++] = arr[right];
                right--;
            }
        }
        return res;
    }

    public int[] getStrongest1(int[] arr, int k) {
        if (null == arr || 0 == arr.length || 0 == k) return null;
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int left = 0;
        int right = arr.length - 1;
        int index = partition(arr, left, right, m);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
            index = partition(arr, left, right, m);
        }
        return Arrays.copyOf(arr, k);
    }

    private int partition(int[] arr, int left, int right, int m) {
        int less = left - 1;
        int more = right;
        int a = Math.abs(arr[right] - m);
        while (left < more) {
            int b = Math.abs(arr[left] - m);
            if (b > a || (b == a && arr[left] > arr[right])) {
                swap(arr, ++less, left++);
            } else if (b < a || (b == a && arr[left] < arr[right])) {
                swap(arr, left, --more);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return less + 1;
    }

    private void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }
}
