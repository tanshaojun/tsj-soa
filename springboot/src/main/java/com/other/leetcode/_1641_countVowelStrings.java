package com.other.leetcode;

/**
 * 1641. 统计字典序元音字符串的数目
 *
 * @Author tansj
 * @Date 2021-04-29 13:44
 * @Version 1.0
 */
public class _1641_countVowelStrings {

    /**
     * 当 n 增加一个长度，对于已有的所有组合结果：
     * 以 a e i o u 开头的，都可以再以 a 开头
     * 以   e i o u 开头的，都可以在以 e 开头
     * ......
     */
    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int j = 1; j < n; j++) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }

}
