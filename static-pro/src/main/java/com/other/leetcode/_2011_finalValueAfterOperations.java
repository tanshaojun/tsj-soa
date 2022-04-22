package com.other.leetcode;

/**
 * 2011. 执行操作后的变量值
 *
 * @Author tansj
 * @Date 2022/4/14 5:05 下午
 * @Version 1.0
 */
public class _2011_finalValueAfterOperations {

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if ("++X".equals(operation) || "X++".equals(operation)) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }

}
