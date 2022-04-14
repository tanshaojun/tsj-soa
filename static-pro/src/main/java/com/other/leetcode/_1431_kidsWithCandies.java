package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 15:19
 */
public class _1431_kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            res.add((candy + extraCandies) >= max);
        }
        return res;
    }
}
