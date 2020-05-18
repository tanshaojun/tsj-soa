package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题45. 把数组排成最小的数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/18 14:40
 */
public class m45_minNumber {

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) list.add(String.valueOf(num));
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

}
