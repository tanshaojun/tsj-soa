package com.other.leetcode;


/**
 * 面试题03. 数组中重复的数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/28 17:37
 */
public class m03_findRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
