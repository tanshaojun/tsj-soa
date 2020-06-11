package com.other.offer;


public class M53 {


    /**
     * 在排序数组中查找数字
     * 统计一个数字在排序数组中出现的次数
     *
     * @param arr
     * @return
     */
    public int getNumberOfK(int[] arr, int k) {
        if (null == arr || 0 == arr.length) return 0;
        int first = getFirstIndex(arr, k);
        int last = getLastIndex(arr, k);
        if (first == -1 && last == -1) return 0;
        return last - first + 1;
    }

    /**
     * 获取k第一次出现的位置
     *
     * @param arr
     * @param k
     * @return
     */
    private int getFirstIndex(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > k) {
                right = mid - 1;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                if (mid == 0 || arr[mid - 1] != k) return mid;
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 获取k最后一次出现的位置
     *
     * @param arr
     * @param k
     * @return
     */
    private int getLastIndex(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > k) {
                right = mid - 1;
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != k) return mid;
                left = mid + 1;
            }
        }
        return -1;
    }


}
