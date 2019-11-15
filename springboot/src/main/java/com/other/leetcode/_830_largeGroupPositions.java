package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 830. 较大分组的位置
 */
public class _830_largeGroupPositions {
    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> lists = new ArrayList<>();
        char[] chars = S.toCharArray();
        int count = 0;
        char tmp = 'A';
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (tmp == 'A') {
                count++;
                tmp = aChar;
            } else {
                if (tmp == aChar) {
                    count++;
                } else {
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i - count);
                        list.add(i - 1);
                        lists.add(list);
                    }
                    count = 1;
                    tmp = aChar;
                }
            }
        }
        if (count >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(S.length() - count);
            list.add(S.length() - 1);
            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("baaaa"));
    }
}
