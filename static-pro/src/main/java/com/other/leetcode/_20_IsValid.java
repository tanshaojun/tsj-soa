package com.other.leetcode;


import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class _20_IsValid {
    public boolean isValid(String s) {
        Stack<String> strings = new Stack<>();
        if ("".equals(s)) return false;
        else {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String s1 = String.valueOf(chars[i]);
                if ("(".equals(s1) || "{".equals(s1) || "[".equals(s1)) {
                    strings.push(s1);
                } else {
                    if (!strings.isEmpty()) {
                        String pop = strings.pop();
                        if (!("(".equals(pop) && ")".equals(s1) || "{".equals(pop) && "}".equals(s1) || "[".equals
                                (pop) && "]".equals(s1))) {
                            return false;
                        }
                    } else return false;
                }
            }
        }
        return !strings.isEmpty() ? false : true;
    }
}
