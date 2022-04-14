package com.other.offer;

public class M21 {


    /**
     * 调整数值顺序使奇数位于偶数前面
     *
     * @param arr
     */
    public void reorderOddEven(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length;

        while (left < right) {
            if (isEven(arr[left])) {
                swap(left, --right, arr);
            } else {
                left++;
            }
        }
    }

    private void swap(int l, int r, int[] arr) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    private boolean isEven(int n) {
        return (n & 1) == 0;
    }


}
