package com.other.leetcode;

import java.util.Stack;

/**
 * 面试题 16.16. 部分排序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/20 15:39
 */
public class m16_16_subSort {

    public int[] subSort(int[] array) {
        int a = -1;
        int b = -1;
        //从左到右找最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max <= array[i]) max = array[i];
            else b = i;
        }
        if (b == -1) return new int[]{a, b};
        //从右到左找最小值
        int min = Integer.MAX_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (min >= array[i]) min = array[i];
            else a = i;
        }
        return new int[]{a, b};
    }

    public int[] subSort1(int[] array) {
        int a = -1;
        int b = -1;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < array.length; i++) {
            if (a != -1) {
                while (!stack.empty() && array[stack.peek()] > array[i]) {
                    max = Math.max(array[stack.pop()], max);
                    a--;
                    b = i;
                }
                if (array[i] < max) b = i;
                max = Math.max(max, array[i]);
                continue;
            }
            if (array[i] >= array[i - 1]) {
                stack.add(i - 1);
            } else {
                max = Math.max(array[i], max);
                stack.add(i - 1);
                a = i;
                b = i;
                while (!stack.empty() && array[stack.peek()] > array[i]) {
                    max = Math.max(array[stack.pop()], max);
                    a--;
                }
            }
        }
        return new int[]{a, b};
    }
}
