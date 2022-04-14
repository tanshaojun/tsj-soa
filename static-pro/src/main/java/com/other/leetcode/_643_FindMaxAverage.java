package com.other.leetcode;

/**
 * 643. 子数组最大平均数 I
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/8 17:05
 */
public class _643_FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxAvg = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];;
            sum -= nums[i - k];
            double avg = sum / k;
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{10, 10, -5, -5, 50, 0}, 6));
    }
}

