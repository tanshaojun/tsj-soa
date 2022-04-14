package com.other.leetcode;

import java.util.Stack;

/**
 * 85. 最大矩形
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/28 13:55
 */
public class _85_maximalRectangle {

    /**
     * 单调栈解法
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (null == matrix || 0 == matrix.length) return 0;
        int max = 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int[] t = new int[y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                t[j] = matrix[i][j] == '0' ? 0 : t[j]++;
            }
            max = Math.max(max, max(t));
        }
        return max;
    }

    private int max(int[] t) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[stack.peek()] >= t[i]) {
                Integer index = stack.pop();
                int next_index = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, t[index] * (i - next_index - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            int next_index = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, t[index] * (t.length - next_index - 1));
        }
        return max;
    }

}
