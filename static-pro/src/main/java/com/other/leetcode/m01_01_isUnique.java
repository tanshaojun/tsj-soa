package com.other.leetcode;

/**
 * 面试题 01.01. 判定字符是否唯一
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/28 14:36
 */
public class m01_01_isUnique {

    public boolean isUnique(String astr) {
        if ("".equals(astr)) return true;
        astr = astr.toUpperCase();
        for (int i = 0; i < 26; i++) {
            String a = String.valueOf((char) (65 + i));
            if (astr.contains(a)) {
                String s = astr.replaceAll(a, "");
                if (s.length() + 1 != astr.length()) {
                    return false;
                }
            }
        }
        return true;
    }

}
