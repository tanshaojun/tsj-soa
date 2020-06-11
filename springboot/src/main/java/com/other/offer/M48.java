package com.other.offer;

import java.util.Arrays;

public class M48 {

    /**
     * 最长不含重复字符的子字符串
     *
     * @param str
     * @return
     */
    public int longestSubstringWithoutDuplication(String str) {
        if (null == str || 0 == str.length()) return 0;
        //记录字母最后一次出现的下标
        int[] position = new int[26];
        Arrays.fill(position, -1);
        int max = 0;
        int curLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int prevIndex = position[str.charAt(i) - 'a'];
            if (-1 == prevIndex || i - prevIndex > curLen) {
                //如果这个字母没出现过或者最后一次出现位置减去前一次出现位置大于当前记录值
                curLen++;
            } else {
                max = Math.max(max, curLen);
                curLen = i - prevIndex;

            }
            //记录下标
            position[str.charAt(i) - 'a'] = i;
        }
        return Math.max(max, curLen);
    }


}
