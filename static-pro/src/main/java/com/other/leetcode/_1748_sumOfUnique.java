package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1748. 唯一元素的和
 *
 * @Author tansj
 * @Date 2021-05-13 13:41
 * @Version 1.0
 */
public class _1748_sumOfUnique {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Boolean> map = new HashMap();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(nums[i])) {
                sum -= nums[i];
                if (map.get(nums[i])) {
                    sum -= nums[i];
                    map.put(nums[i], false);
                }
                continue;
            }
            map.put(nums[i], true);
        }
        return sum;
    }

}
