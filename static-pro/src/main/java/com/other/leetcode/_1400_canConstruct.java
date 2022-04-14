package com.other.leetcode;

/**
 * 1400. 构造 K 个回文字符串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/29 9:36
 */
public class _1400_canConstruct {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 97] += 1;
        }
        int min = 0;
        for (int i : ints) {
            if ((i & 1) == 1) min++;
        }
        return min <= k;
    }

}
