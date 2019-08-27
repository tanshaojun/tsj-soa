package com.other.leetcode;

/**
 * 1170. 比较字符串最小字母出现频次
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/8/27 13:48
 */
public class _1170_NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] tmp = new int[10];
        for (int i = 0; i < words.length; i++) {
            tmp[f(words[i]) - 1] += 1;
        }
        for (int i = tmp.length - 2; i >= 0; i--) {
            tmp[i] += tmp[i + 1];
        }
        int[] ints = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int f = f(queries[i]);
            if (f < 10) {
                ints[i] = tmp[f];
            }
        }
        return ints;
    }

    private static int f(String word) {
        int[] ints = new int[26];
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return ints[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }
}
