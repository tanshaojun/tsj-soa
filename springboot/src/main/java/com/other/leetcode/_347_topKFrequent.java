package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/15 14:51
 */
public class _347_topKFrequent {

    /**
     * 使用api
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer count : map.keySet()) {
            priorityQueue.add(count);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        int[] res = new int[k];
        while (!priorityQueue.isEmpty())
            res[k - priorityQueue.size()] = priorityQueue.poll();
        return res;
    }

    /**
     * 自己建堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[k];
        int[] heap = new int[k];
        int size = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            add(m.getKey(), m.getValue(), size++, heap, res);
        }
        return res;
    }

    private void add(Integer k, Integer v, int len, int[] heap, int[] res) {
        if (len < heap.length) {
            heap[len] = v;
            res[len] = k;
            if (len == heap.length - 1) {
                heapUp(heap, res);
            }
        } else {
            if (heap[0] < v) {
                heap[0] = v;
                res[0] = k;
                heapDown(heap, res, 0);
            }
        }
    }

    private void heapUp(int[] heap, int[] res) {
        int len = heap.length;
        for (int i = (len / 2) - 1; i >= 0; i--) {
            heapDown(heap, res, i);
        }
    }

    private void heapDown(int[] heap, int[] res, int index) {
        int leftIndex = 2 * index + 1;
        int len = heap.length;
        while (leftIndex < len) {
            int rightIndex = leftIndex + 1;
            int min = rightIndex < len && heap[rightIndex] < heap[leftIndex] ? rightIndex : leftIndex;
            min = heap[min] < heap[index] ? min : index;
            if (min == index) break;
            swap(heap, min, index);
            swap(res, min, index);
            index = min;
            leftIndex = 2 * index + 1;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
