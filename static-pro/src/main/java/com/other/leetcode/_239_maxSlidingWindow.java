package com.other.leetcode;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/20 9:52
 */
public class _239_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (0 == k || 0 == nums.length) return new int[]{};
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) list.pollLast();
            list.addLast(i);
            if ((i - k + 1) > list.getFirst()) list.pollFirst();
            if ((i - k + 1) >= 0) res[index++] = nums[list.getFirst()];
        }
        return res;
    }

}
