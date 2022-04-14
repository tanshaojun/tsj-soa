package com.other.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/4 18:19
 */
public class _907_sumSubarrayMins {


    /**
     * 单调栈
     * 维护一个递增的栈，当栈顶元素大于当前元素
     * <p>
     * 则计算栈顶元素为最小值的个数
     * 栈顶元素下标：m
     * 以栈顶元素为最小值的左右的边界，left，right
     * 则结果为 A[m]*(m-left)*(right-m)
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {
        if (null == A || 0 == A.length) return 0;
        int res = 0;
        int m = 1000000007;
        int right = A.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < right; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                Integer mid = stack.pop();
                Integer left = stack.isEmpty() ? -1 : stack.peek();
                res += A[mid] * (i - mid) * (mid - left);
                res %= m;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer mid = stack.pop();
            Integer left = stack.isEmpty() ? -1 : stack.peek();
            res += A[mid] * (right - mid) * (mid - left);
            res %= m;
        }
        return res;
    }

    /**
     * 滑动窗口超时
     *
     * @param A
     * @return
     */
    public static int sumSubarrayMins1(int[] A) {
        if (null == A || 0 == A.length) return 0;
        int res = 0;
        int min = Integer.MAX_VALUE;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            res += A[i];
            min = Math.min(min, A[i]);
        }
        int m = 1000000007;
        if (len > 1) res += min;
        int count = 2;
        while (count < len) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < A.length; i++) {
                while (!deque.isEmpty() && A[deque.getLast()] > A[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
                if (i - count >= deque.getFirst()) {
                    deque.pollFirst();
                }
                if (i + 1 >= count) {
                    res += A[deque.getFirst()];
                    res %= m;
                }
            }
            count++;
        }
        return res;
    }

}
