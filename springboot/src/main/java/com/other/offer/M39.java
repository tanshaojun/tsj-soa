package com.other.offer;

public class M39 {


    /**
     * 数组中超过一半的数字
     * <p>
     * 遇到相等的数count加1，不相等就减1，如果存在一个数在数组中占一半，则遍历完当前值必定是这个数
     *
     * @param arr
     * @return
     */
    public int moreThanHaIfNum(int[] arr) {
        if (null == arr || 0 == arr.length) return -1;
        int count = 1;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (cur == arr[i]) {
                count++;
            } else if (count >= 1) {
                count--;
            } else {
                count = 1;
                cur = arr[i];
            }
        }
        //验证这个数是否在数组中占一半以上，如果数组中不存在占一半以上的数，则答案是错误的
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur == arr[i]) count++;
        }
        return count > arr.length / 2 ? cur : -1;
    }

    /**
     * 利用快排函数
     *
     * @param arr
     * @return
     */
    public int moreThanHaIfNum1(int[] arr) {
        if (null == arr || 0 == arr.length) return -1;
        int len = arr.length;
        int mid = len >> 1;
        int left = 0;
        int right = len - 1;
        int index = partition(arr, left, right);
        while (index != mid) {
            if (index > mid) {
                right = index - 1;
                index = partition(arr, left, right);
            } else {
                left = index + 1;
                index = partition(arr, left, right);
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[index] == arr[i]) count++;
        }
        return count > arr.length / 2 ? arr[index] : -1;

    }

    private int partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] > arr[right]) {
                swap(arr, left, --more);
            } else if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
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
