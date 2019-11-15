package com.other.leetcode;

import java.util.Stack;

/**
 * 485. 最大连续1的个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/14 14:44
 */
public class _485_FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (!stack.isEmpty()) {
                    int size = stack.size();
                    if (size > max) max = size;
                    stack.clear();
                }
            } else
                stack.push(nums[i]);

        }
        return max == 0 ? (!stack.isEmpty() ? stack.size() : 0) : ((!stack.isEmpty() && max < stack.size()) ? stack
                .size() : max);
    }
}
