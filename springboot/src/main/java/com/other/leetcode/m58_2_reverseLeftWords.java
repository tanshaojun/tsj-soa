package com.other.leetcode;

/**
 * 面试题58 - II. 左旋转字符串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/21 10:06
 */
public class m58_2_reverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

}
