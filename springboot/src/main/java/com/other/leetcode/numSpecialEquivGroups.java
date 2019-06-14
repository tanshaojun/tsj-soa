package com.other.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/614:24
 */
public class numSpecialEquivGroups {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            if (s.length() > 2) {
                StringBuffer sb = new StringBuffer("");
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (j % 2 == 0) {
                        sb.append(chars[j]);
                    }
                }
                for (int j = 0; j < chars.length; j++) {
                    if (j % 2 != 0) {
                        sb.append(chars[j]);
                    }
                }
                set.add(sb.toString());
            } else set.add(s);
        }
        return set.size();
    }
}
