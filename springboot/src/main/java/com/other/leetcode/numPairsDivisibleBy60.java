package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/316:06
 */
public class numPairsDivisibleBy60 {

    public static int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        int[] index = new int[60];
        for (int t : time) {
            result += index[(60 - t % 60) % 60];
            index[t % 60]++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }
}
