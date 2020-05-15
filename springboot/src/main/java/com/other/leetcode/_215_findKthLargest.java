package com.other.leetcode;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 14:26
 */
public class _215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i], len++, heap);
        }
        return heap[0];
    }

    private void add(int v, int len, int[] heap) {
        if (len < heap.length) {
            heap[len] = v;
            if (len == heap.length - 1) {
                heapUp(heap);
            }
        } else {
            if (heap[0] < v) {
                heap[0] = v;
                heapDown(heap, 0);
            }
        }
    }

    private void heapUp(int[] heap) {
        for (int i = (heap.length / 2) - 1; i >= 0; i--) {
            heapDown(heap, i);
        }
    }

    private void heapDown(int[] heap, int index) {
        int len = heap.length;
        int lIdx = 2 * index + 1;
        while (lIdx < len) {
            int rIdx = lIdx + 1;
            int min = rIdx < len && heap[rIdx] < heap[lIdx] ? rIdx : lIdx;
            min = heap[min] < heap[index] ? min : index;
            if (min == index) break;
            swap(heap, index, min);
            index = min;
            lIdx = 2 * index + 1;
        }

    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
