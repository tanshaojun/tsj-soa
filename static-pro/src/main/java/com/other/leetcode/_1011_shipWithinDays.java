package com.other.leetcode;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/7 13:45
 */
public class _1011_shipWithinDays {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        int res = Integer.MAX_VALUE;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int a = 0;
            int day = 1;
            for (int weight : weights) {
                a += weight;
                if (mid < a) {
                    a = weight;
                    day++;
                }
            }
            if (day > D) {
                min = mid + 1;
            } else if (day < D) {
                max = mid;
            } else {
                max = mid;
                res = res > mid ? mid : res;
            }
        }
        return res != Integer.MAX_VALUE ? res : min;
    }


}
