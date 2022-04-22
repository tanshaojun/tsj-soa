package com.other.leetcode;

/**
 * 1689. 十-二进制数的最少数目
 *
 * @Author tansj
 * @Date 2022/4/14 5:28 下午
 * @Version 1.0
 */
public class _1689_minPartitions {

    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        return res;
    }

}
