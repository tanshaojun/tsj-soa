package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/31 14:17
 */
public class _1104_pathInZigZagTree {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(26));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int level = 1;
        int tail = 2;
        while (tail <= label) {
            tail *= 2;
            level++;
        }
        tail = tail - 1;
        int head = tail / 2 + 1;
        while (level > 0) {
            res.add(0, label);
            label = label % 2 == 0 ? label / 2 : (label - 1) / 2;
            tail = head - 1;
            head = tail / 2 + 1;
            label = tail - (label - head);
            level--;
        }
        return res;
    }
}
