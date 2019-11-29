package com.other.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/29 16:47
 */
public class _179_largestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int i = 0;
        for (int n : nums)
            strs[i++] = String.valueOf(n);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (strs[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s);
        return sb.toString();
    }
}
