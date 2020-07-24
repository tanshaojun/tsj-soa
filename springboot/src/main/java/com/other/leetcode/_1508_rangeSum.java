package com.other.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1508. 子数组和排序后的区间和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/22 17:43
 */
public class _1508_rangeSum {

    public int rangeSum(int[] nums, int n, int left, int right) {
        if (null == nums) return 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long res = 0;
        long m = 1000000007L;
        for (int i = left - 1; i < right; i++) {
            res = res % m + list.get(i) % m;
            res %= m;
        }
        return (int) res;
    }

}
