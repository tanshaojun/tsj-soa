package com.other.leetcode;

/**
 * 1103. 分糖果 II
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/29 17:13
 */
public class _1103_distributeCandies {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int a = 1;
        for (int i = 1; i <= num_people && candies > 0; ) {
            res[i - 1] += a;
            i++;
            candies -= a;
            a++;
            if (i > num_people) i = 1;
            if (candies - a < 0) {
                a = candies;
                res[i - 1] += a;
                break;
            }
        }
        return res;
    }

}
