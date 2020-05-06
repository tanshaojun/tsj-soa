package com.other.leetcode;

/**
 * 面试题 17.19. 消失的两个数字
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/6 17:50
 */
public class m17_19_missingTwo {

    public int[] missingTwo(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int n = nums.length + 2;
        for (int i = 1; i <= n; i++) {
            tmp ^= i;
        }
        int c = tmp & -tmp;
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((c & nums[i]) == 0) {
                a ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((c & i) == 0) {
                a ^= i;
            }
        }
        return new int[]{a, a ^ tmp};
    }
}
