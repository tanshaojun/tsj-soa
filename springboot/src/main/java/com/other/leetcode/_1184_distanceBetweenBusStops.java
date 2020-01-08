package com.other.leetcode;

/**
 * 1184. 公交站间的距离
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/6 17:00
 */
public class _1184_distanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int d : distance)
            sum += d;
        int min = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        for (int i = start; i < destination; i++)
            min += distance[i];
        return sum - min > min ? min : sum - min;
    }
}
