package com.other.leetcode;

/**
 * 1387. 将整数按权重排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 13:49
 */
public class _1387_getKth {

    public int getKth(int lo, int hi, int k) {
        int[] arr = new int[hi - lo + 1];
        int[] w = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            int x = i;
            int count = 0;
            while (x > 1) {
                if ((x & 1) == 1) x = 3 * x + 1;
                else x /= 2;
                count++;
            }
            w[i - lo] = count;
            arr[i - lo] = i;
        }
        mergeSort(arr, w, 0, arr.length - 1, lo);
        return arr[k - 1];
    }

    private void mergeSort(int[] arr, int[] w, int left, int right, int lo) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, w, left, mid, lo);
            mergeSort(arr, w, mid + 1, right, lo);
            merge(arr, w, left, right, mid, lo);
        }
    }

    private void merge(int[] arr, int[] w, int left, int right, int mid, int lo) {
        int[] t = new int[right - left + 1];
        int less = left;
        int more = mid + 1;
        int index = 0;
        while (less <= mid && more <= right) {
            if (w[arr[less] - lo] > w[arr[more] - lo]) {
                t[index++] = arr[more++];
            } else if (w[arr[less] - lo] < w[arr[more] - lo]) {
                t[index++] = arr[less++];
            } else
                t[index++] = arr[less] > arr[more] ? arr[more++] : arr[less++];

        }
        while (less <= mid)
            t[index++] = arr[less++];
        while (more <= right)
            t[index++] = arr[more++];
        for (int i = 0; i < t.length; i++)
            arr[left + i] = t[i];

    }

}
