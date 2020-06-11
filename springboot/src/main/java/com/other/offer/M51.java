package com.other.offer;


public class M51 {


    int res = 0;


    /**
     * 数组中的逆序对
     * <p>
     * 归并排序求逆序对
     *
     * @param arr
     * @return
     */
    public int inversePairs(int[] arr) {
        if (null == arr || 0 == arr.length) return 0;
        mergeSort(arr, 0, arr.length - 1);
        return res;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] t = new int[right - left + 1];
        int less = left;
        int more = mid + 1;
        int index = 0;
        while (less <= mid && more <= right) {
            if (arr[less] > arr[more]) {
                t[index++] = arr[more++];
                res += (mid - less + 1);
            } else {
                t[index++] = arr[less++];

            }
        }
        while (less <= mid) {
            t[index++] = arr[less++];
        }
        while (more <= right) {
            t[index++] = arr[more++];
        }
        for (int i = 0; i < t.length; i++) {
            arr[left + i] = t[i];
        }
    }


}
