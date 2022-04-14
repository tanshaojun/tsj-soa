package com.other.leetcode;

/**
 * 面试题 17.09. 第 k 个数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 16:35
 */
public class m17_09_getKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int a = 0, b = 0, c = 0, min;
        for (int i = 1; i < res.length; i++) {
            min = Math.min(Math.min(res[a] * 3, res[b] * 5), res[c] * 7);
            res[i] = min;
            if (min == res[a] * 3) a++;
            if (min == res[b] * 5) b++;
            if (min == res[c] * 7) c++;
        }
        return res[--k];
    }

}
