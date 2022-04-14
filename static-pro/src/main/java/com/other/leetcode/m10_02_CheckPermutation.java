package com.other.leetcode;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/30 14:43
 */
public class m10_02_CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars, 0, chars.length);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2, 0, chars2.length);
        String s3 = new String(chars);
        String s4 = new String(chars2);
        return s3.equals(s4);
    }
}
