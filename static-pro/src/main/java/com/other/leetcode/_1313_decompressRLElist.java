package com.other.leetcode;

/**
 * 1313. 解压缩编码列表
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/23 15:22
 */
public class _1313_decompressRLElist {

    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res[index++] = nums[i + 1];
            }
        }
        return res;
    }

}
