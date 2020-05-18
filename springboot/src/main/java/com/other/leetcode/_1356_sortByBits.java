package com.other.leetcode;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 16:38
 */
public class _1356_sortByBits {

    public int[] sortByBits(int[] arr) {
        int[] a = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            int count = 0;
            while (t > 0) {
                if ((t & 1) == 1) count++;
                t >>= 1;
            }
            a[arr[i]] = count;
        }
        mergeSort(a, arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int[] a, int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(a, arr, left, mid);
            mergeSort(a, arr, mid + 1, right);
            merge(a, arr, left, mid, right);
        }
    }

    private void merge(int[] a, int[] arr, int left, int mid, int right) {
        int[] t = new int[right - left + 1];
        int less = left;
        int more = mid + 1;
        int index = 0;
        while (less <= mid && more <= right) {
            if (a[arr[less]] > a[arr[more]]) {
                t[index++] = arr[more++];
            } else if (a[arr[less]] < a[arr[more]]) {
                t[index++] = arr[less++];
            } else {
                t[index++] = arr[less] > arr[more] ? arr[more++] : arr[less++];
            }
        }
        while (less <= mid)
            t[index++] = arr[less++];
        while (more <= right)
            t[index++] = arr[more++];
        for (int i = 0; i < t.length; i++)
            arr[left + i] = t[i];
    }

}
