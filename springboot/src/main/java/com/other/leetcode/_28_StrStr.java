package com.other.leetcode;

/**
 * 28. 实现strStr()
 */
public class _28_StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if ("".equals(needle)) return 0;
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int[] next_arr = getNextArr(needles);
        int i1 = 0;
        int i2 = 0;
        while (i1 < haystack.length() && i2 < needle.length()) {
            if (haystacks[i1] == needles[i2]) {
                i1++;
                i2++;
            } else if (next_arr[i2] == -1) {
                i1++;
            } else {
                i2 = next_arr[i2];
            }
        }
        return i2 == needles.length ? i1 - i2 : -1;
    }

    private int[] getNextArr(char[] needles) {
        int len = needles.length;
        if (1 == len) return new int[]{-1};
        int[] res = new int[len];
        res[0] = -1;
        res[1] = 0;
        int index = 2;
        int preNum = 0;
        while (index < len) {
            if (needles[index - 1] == needles[preNum]) {
                res[index++] = ++preNum;
            } else if (preNum > 0) {
                preNum = res[preNum];
            } else {
                res[index++] = 0;
            }
        }
        return res;
    }

    public int strStr1(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if ("".equals(needle)) return 0;
        int index = 0;
        int a = -1;
        int t = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (index > needle.length() - 1) return a;
            char c = haystack.charAt(i);
            char c1 = needle.charAt(index);
            if (c == needle.charAt(0) && index != 0 && t == -1) t = i;
            if (c == c1) {
                index++;
                if (a == -1) a = i;
            } else {
                if (t != -1) i = t - 1;
                t = -1;
                index = 0;
                a = -1;
            }
        }
        if (index != needle.length()) return -1;
        return a;
    }
}
