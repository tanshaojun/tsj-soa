package com.other.leetcode;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/7/24 17:35
 */
public class _1491_average {

    public double average(int[] salary) {
        if (null == salary) return 0.0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }
        return (sum - min - max) / (salary.length - 2);
    }

}
