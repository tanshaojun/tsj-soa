package com.other.leetcode;

/**
 * 621. 任务调度器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/8 16:35
 */
public class _621_leastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] ints = new int[26];
        int max = Integer.MIN_VALUE;
        for (char task : tasks) {
            ints[task - 'A'] += 1;
            max = Math.max(max, ints[task - 'A']);
        }
        int count = 0;
        for (int i : ints) {
            if (i == max) count++;
        }
        return Math.max((max - 1) * (n + 1) + count, tasks.length);
    }

}
