package com.other.leetcode;

/**
 * 521. 最长特殊序列 Ⅰ
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/5/3118:17
 */
public class _521_FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }
}
