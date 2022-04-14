package com.other.leetcode;

/**
 * 1370. 上升下降字符串
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/19 16:51
 */
public class _1370_sortString {

    public String sortString(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 97] += 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() != s.length()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    arr[i] -= 1;
                    sb.append((char) (i + 97));
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    arr[i] -= 1;
                    sb.append((char) (i + 97));
                }
            }
        }
        return sb.toString();
    }

}