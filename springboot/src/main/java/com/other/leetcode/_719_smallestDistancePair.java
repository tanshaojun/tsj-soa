package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 719. 找出第 k 小的距离对
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 13:46
 */
public class _719_smallestDistancePair {

    /**
     * 在最大值的差值和0之间二分
     * <p>
     * 计算查找小于mi的数量
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                //因为数组已经排好序了，相减如果大于mi，则需要增加left
                while (nums[right] - nums[left] > mi) {
                    left++;
                }
                //计算小于mi的数量
                count += right - left;
            }
            if (count >= k) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    /**
     * 堆超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair1(int[] nums, int k) {
        if (null == nums || 0 == nums.length || 0 == k) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        process(nums, k, 0, priorityQueue, new ArrayList<>());
        return priorityQueue.peek();

    }

    private void process(int[] nums, int k, int start, PriorityQueue<Integer> priorityQueue,
                         List<Integer> list) {
        if (list.size() == 2) {
            int abs = Math.abs(list.get(0) - list.get(1));
            if (priorityQueue.size() < k || priorityQueue.peek() > abs) {
                priorityQueue.add(abs);
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            process(nums, k, i + 1, priorityQueue, list);
            list.remove(list.size() - 1);
        }
    }

}
