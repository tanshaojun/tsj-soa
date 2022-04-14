package com.other.leetcode;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/26 14:05
 */
public class _1402_maxSatisfaction {
    /**
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        int sum = 0, res = 0;
        Arrays.sort(satisfaction);
        //-1,-8,0,5,-9
        //sort之后 5 ,0 ,-1, -8, -9
        // sum = 5,res = 5;
        // sum = 5,res = 10
        // sum = 4,res = 14
        // sum = -1 此时退出，res就是最大值
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum < 0) break;
            res += sum;
        }
        return res;
    }

    /**
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction1(int[] satisfaction) {
        int res = 0;
        Arrays.sort(satisfaction);
        int count = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            res += (satisfaction[i] * (i + 1));
            if (satisfaction[i] < 0) count++;
        }
        if (satisfaction[satisfaction.length - 1] <= 0) return 0;
        int t = 1;
        while (t < count) {
            int j = 1;
            int tmax = 0;
            for (int i = t; i < satisfaction.length; i++) {
                tmax += (satisfaction[i] * j);
                j++;
            }
            res = Math.max(res, tmax);
            t++;
        }
        return res;

    }
}
