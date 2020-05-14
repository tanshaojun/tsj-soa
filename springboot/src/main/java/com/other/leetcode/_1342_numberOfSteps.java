package com.other.leetcode;

/**
 * 1342. 将数字变成 0 的操作次数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/14 16:33
 */
public class _1342_numberOfSteps {

    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            if ((num & 1) == 1) {
                num -= 1;
            } else num /= 2;
        }
        return res;
    }

}
