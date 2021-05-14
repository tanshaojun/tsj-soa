package com.other.leetcode;

/**
 * 1701. 平均等待时间
 *
 * @Author tansj
 * @Date 2021-05-11 13:32
 * @Version 1.0
 */
public class _1701_averageWaitingTime {

    public double averageWaitingTime(int[][] customers) {
        int start;
        int end = 0;
        double sum = 0;
        for (int i = 0; i < customers.length; i++) {
            start = customers[i][0];
            if (customers[i][0] >= end) {
                end = start + customers[i][1];
            } else {
                end += customers[i][1];
            }
            sum += (end - start);
        }
        return sum / customers.length;
    }

}
