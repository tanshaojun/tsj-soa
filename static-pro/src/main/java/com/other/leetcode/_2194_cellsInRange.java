package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2194. Excel 表中某个范围内的单元格
 *
 * @Author tansj
 * @Date 2022/4/21 16:33
 * @Version 1.0
 */
public class _2194_cellsInRange {

    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char a = s.charAt(0);
        char b = s.charAt(1);
        char c = s.charAt(3);
        char d = s.charAt(4);
        int aa = b - '0';
        int bb = d - '0';
        while (a <= c) {
            res.add(String.valueOf(a) + aa);
            if (aa == bb) {
                aa = b - '0';
                a += 1;
            } else {
                aa++;
            }
        }
        return res;
    }

}
