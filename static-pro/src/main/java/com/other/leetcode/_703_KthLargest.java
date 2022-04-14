package com.other.leetcode;


/**
 * 703. 数据流中的第K大元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 11:27
 */
public class _703_KthLargest {

    int[] arr;
    int len;

    public _703_KthLargest(int k, int[] nums) {
        this.arr = new int[k];
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (len < arr.length) {
            len++;
            arr[len - 1] = val;
            if (len == arr.length)
                heapInsert();
        } else {
            if (arr[0] < val) {
                arr[0] = val;
                heapfiy(0);
            }
        }
        return arr[0];
    }

    /**
     * 调整堆
     *
     * @param index
     */
    private void heapfiy(int index) {
        int leftIdx = 2 * index + 1;
        while (leftIdx < arr.length) {
            int rightIdx = leftIdx + 1;
            int maxIdx = rightIdx < arr.length && arr[rightIdx] < arr[leftIdx] ? rightIdx : leftIdx;
            maxIdx = arr[maxIdx] < arr[index] ? maxIdx : index;
            if (maxIdx == index) break;
            swap(arr, index, maxIdx);
            index = maxIdx;
            leftIdx = 2 * index + 1;
        }
    }

    /**
     * 堆化
     */
    private void heapInsert() {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapfiy(i);
        }
    }


    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
