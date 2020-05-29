package com.other.leetcode;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/28 11:07
 */
public class _84_largestRectangleArea {

    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (null == heights || 0 == heights.length) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                Integer index = stack.pop();
                maxarea = Math.max(maxarea, heights[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }

    /**
     * 暴力
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        if (null == heights || 0 == heights.length) return 0;
        int len = heights.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            max = Math.max(min, max);
            for (int j = i + 1; j < len; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j - i + 1) * min);
            }
        }
        return max;
    }

}
