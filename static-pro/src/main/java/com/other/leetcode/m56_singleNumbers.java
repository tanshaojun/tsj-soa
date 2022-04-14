package com.other.leetcode;

/**
 * 面试题56 - I. 数组中数字出现的次数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/28 11:46
 */
public class m56_singleNumbers {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) sum ^= num;
        int tmp = sum & (-sum);
        int[] res = new int[2];
        for (int num : nums) {
            if ((tmp & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

}
