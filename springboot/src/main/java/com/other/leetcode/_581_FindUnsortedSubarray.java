package com.other.leetcode;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/9/20 10:22
 */
public class _581_FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != clone[i]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != clone[i]) {
                right = i;
                break;
            }
        }
        return right == left ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 4, 4, 8, 10, 9, 15}));
    }

}
