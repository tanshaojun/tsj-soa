package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2020/6/12 17:22
 */
public class _1352_ProductOfNumbers {

    List<Integer> sumList = new ArrayList<>();
    int pre = 1;
    int zore_index = -1;

    public _1352_ProductOfNumbers() {

    }

    public void add(int num) {
        if (num == 0) {
            sumList.add(0);
            pre = 1;
            zore_index = sumList.size() - 1;
        } else {
            pre = pre * num;
            sumList.add(pre);
        }
    }

    public int getProduct(int k) {
        int right = sumList.size() - 1;
        int left = right - k;
        if (zore_index > left) return 0;
        if (right + 1 == k) return sumList.get(right);
        return sumList.get(right) / (sumList.get(left) == 0 ? 1 : sumList.get(left));
    }

}
