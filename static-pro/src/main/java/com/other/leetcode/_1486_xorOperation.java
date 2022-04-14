package com.other.leetcode;

/**
 * 1486. 数组异或操作
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/22 10:10
 */
public class _1486_xorOperation {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= (start + 2 * i);
        }
        return res;
    }
}
