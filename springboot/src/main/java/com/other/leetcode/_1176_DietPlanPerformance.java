package com.other.leetcode;

/**
 * 1176. 健身计划评估
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/19 19:17
 */
public class _1176_DietPlanPerformance {

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if (calories.length == 0) return 0;
        int sum = 0;
        int t = 0;
        for (int i = 0; i < k; i++)
            t += calories[i];
        if (t < lower) sum--;
        if (t > upper) sum++;
        for (int i = k; i < calories.length; i++) {
            t += calories[i];
            t -= calories[i - k];
            if (t < lower) sum--;
            if (t > upper) sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3));
    }

}
