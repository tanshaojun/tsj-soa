package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.24. 数对和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/12 15:45
 */
public class m16_24_pairSums {


    public List<List<Integer>> pairSums(int[] nums, int target) {
        if (null == nums || nums.length < 2) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

}
