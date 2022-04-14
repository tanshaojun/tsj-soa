package com.other.leetcode;


import java.util.Arrays;

/**
 * 1051. 高度检查器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 14:45
 */
public class _1051_HeightChecker {

    public static int heightChecker(int[] heights) {
        int[] ints = Arrays.copyOf(heights, heights.length);
        Arrays.sort(ints);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (ints[i] != heights[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
