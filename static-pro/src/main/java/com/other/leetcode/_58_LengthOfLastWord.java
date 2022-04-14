package com.other.leetcode;

/**
 * 58. 最后一个单词的长度
 */
public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split.length > 0 ? split[split.length - 1].length() : 0;
    }
}
