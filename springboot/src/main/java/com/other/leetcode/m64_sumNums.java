package com.other.leetcode;

/**
 * 面试题64. 求1+2+…+n
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/2 16:55
 */
public class m64_sumNums {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
