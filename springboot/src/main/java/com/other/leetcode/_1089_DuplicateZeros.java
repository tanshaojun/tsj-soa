package com.other.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1089. 复写零
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/6 16:49
 */
public class _1089_DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        for (int i = 0; i < arr.length; i++) {
            Integer poll = queue.poll();
            arr[i] = poll;
            if (poll == 0 && (i + 1) < arr.length) {
                arr[++i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        duplicateZeros(new int[]{0,0,0,0,0,0,0});
    }
}
