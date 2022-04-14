package com.other.leetcode;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 14:15
 */
public class _739_dailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

}
