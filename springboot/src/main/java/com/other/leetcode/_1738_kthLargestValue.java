package com.other.leetcode;

import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @Author tansj
 * @Date 2021-05-14 14:57
 * @Version 1.0
 */
public class _1738_kthLargestValue {

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] preSum = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                preSum[i][j] = matrix[i - 1][j - 1] ^ preSum[i - 1][j] ^ preSum[i][j - 1] ^ preSum[i - 1][j - 1];
                minHeap.add(preSum[i][j]);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();
    }

}
