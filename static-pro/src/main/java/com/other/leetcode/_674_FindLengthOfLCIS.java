package com.other.leetcode;

/**
 * 674. 最长连续递增序列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 20:02
 */
public class _674_FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int max = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            max = count > max ? count : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 2, 3, 4, 5}));
    }
}
