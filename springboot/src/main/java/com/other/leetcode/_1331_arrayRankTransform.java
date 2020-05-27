package com.other.leetcode;

/**
 * 1331. 数组序号转换
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/26 14:24
 */
public class _1331_arrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        if (null == arr || 0 == arr.length) return new int[]{};
        int[] index_arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            index_arr[i] = i;
        }
        quickSort(0, arr.length - 1, arr, index_arr);
        int[] res = new int[arr.length];
        int index = 1;
        res[index_arr[0]] = index;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                res[index_arr[i]] = index;
            } else {
                res[index_arr[i]] = ++index;
            }
        }
        return res;
    }

    private void quickSort(int left, int right, int[] arr, int[] index_arr) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            swap(right, mid, arr, index_arr);
            int[] t = partition(left, right, arr, index_arr);
            quickSort(left, t[0] - 1, arr, index_arr);
            quickSort(t[1] + 1, right, arr, index_arr);
        }
    }

    private int[] partition(int left, int right, int[] arr, int[] index_arr) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(++less, left++, arr, index_arr);
            } else if (arr[left] > arr[right]) {
                swap(--more, left, arr, index_arr);
            } else {
                left++;
            }
        }
        swap(more, right, arr, index_arr);
        return new int[]{less + 1, more};
    }

    private void swap(int right, int mid, int[] arr, int[] index_arr) {
        int t = arr[right];
        arr[right] = arr[mid];
        arr[mid] = t;

        t = index_arr[right];
        index_arr[right] = index_arr[mid];
        index_arr[mid] = t;
    }

}
