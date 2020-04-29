package com.other.leetcode;

/**
 * 3.无重复字符的最长子串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/4/29 17:20
 */
public class _3_lengthOfLongestSubstring {

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) return 0;
        int start = 0;
        int end = 1;
        int res = 1;
        while (start < s.length() && end < s.length()) {
            int index = s.substring(start, end).indexOf(s.charAt(end));
            if (index != -1) {
                start += (index + 1);
            } else {
                end++;
                res = Math.max(res, (end - start));
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (null == s || "".equals(s)) return 0;
        int res = 1;
        lable:
        for (int i = 0; i < s.length(); ) {
            if (s.length() - i < res) return res;
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                if (sub.contains(String.valueOf(s.charAt(j)))) {
                    i += (sub.indexOf(s.charAt(j)) + 1);
                    continue lable;
                } else {
                    res = Math.max(res, j - i + 1);
                }
            }
            i++;
        }
        return res;
    }
}
