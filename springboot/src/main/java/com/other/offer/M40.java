package com.other.offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class M40 {


    /**
     * 最小的k个数
     * <p>
     * 利用堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumber(int[] arr, int k) {
        if (null == arr || 0 == arr.length || k >= arr.length) return arr;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int a : arr) {
            if (queue.size() < k || queue.peek() > a) {
                queue.add(a);
                if (queue.size() > k) queue.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

    /**
     * 在可以修改原数组的前提下利用快排函数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumber2(int[] arr, int k) {
        if (null == arr || 0 == arr.length || k >= arr.length) return arr;
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int index = partition(arr, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
                index = partition(arr, left, right);
            } else {
                left = index + 1;
                index = partition(arr, left, right);
            }
        }
        return Arrays.copyOfRange(arr, 0, k);
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

    /**
     * 最小的k个数
     * <p>
     * 排序查找
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumber1(int[] arr, int k) {
        if (null == arr || 0 == arr.length || k >= arr.length) return arr;
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

}
