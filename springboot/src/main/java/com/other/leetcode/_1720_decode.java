package com.other.leetcode;

/**
 * 1720. 解码异或后的数组
 *
 * @Author tansj
 * @Date 2021-05-06 10:06
 * @Version 1.0
 */
public class _1720_decode {

    /**
     * a^b = c  等于 a^c = b 等于 b^c =a
     *
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        if (null == encoded || 0 == encoded.length) {
            return new int[]{};
        }
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }
}
