package com.other.leetcode;

/**
 * 392. 判断子序列
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/9 14:51
 */
public class _392_isSubsequence {

    /**
     * dp解法
     *  #ahbgdc
     * #1111111
     * a0111111
     * x0000000
     * c0000000
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s) || s.equals(t)) return true;
        if ("".equals(t)) return false;
        int x = s.length();
        int y = t.length();
        boolean[][] dp = new boolean[x + 1][y + 1];
        for (int i = 0; i <= y; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[x][y];
    }

    /**
     * 普通解法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        if ("".equals(s) || s.equals(t)) return true;
        if ("".equals(t)) return false;
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = start; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    start = j + 1;
                    count++;
                    break;
                }
            }
            if (count != (i + 1)) break;
        }
        return count == s.length();
    }
}
