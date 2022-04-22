package com.other.leetcode;

/**
 * 2114. 句子中的最多单词数
 *
 * @Author tansj
 * @Date 2022/4/15 11:08
 * @Version 1.0
 */
public class _2114_mostWordsFound {

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            res = Math.max(res, sentence.split(" ").length);
        }
        return res;
    }

}
