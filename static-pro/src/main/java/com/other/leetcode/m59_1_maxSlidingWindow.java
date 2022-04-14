package com.other.leetcode;

import java.util.LinkedList;

/**
 * 面试题59 - I. 滑动窗口的最大值o
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/22 15:03
 */
public class m59_1_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.pollLast();
            list.addLast(i);
            if (i - k + 1 > list.getFirst()) list.pollFirst();
            if (i - k + 1 >= 0) res[index++] = nums[list.getFirst()];
        }
        return res;
    }

}
