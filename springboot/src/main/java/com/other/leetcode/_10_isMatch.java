package com.other.leetcode;

/**
 * 10. 正则表达式匹配
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/28 14:52
 */
public class _10_isMatch {

    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if (slen == 0 && plen == 0) return true;
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        //dp[i][j]表示s的0到i-1和p的0到j-1是否匹配
        dp[0][0] = true;
        //初始化s=0
        for (int j = 2; j <= plen; j++) {
            //当s为空时，a*b*c*可以匹配.
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        //for循环当s长度为1时能否匹配，一直到s长度为slen
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= plen; j++) {
                //最简单的两种情况   字符相等或者p的字符是‘.'
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //p当前字符是*时，要判断*前边一个字符和s当前字符
                else if (p.charAt(j - 1) == '*') {
                    if (j < 2) dp[i][j] = false;
                    //如果p的*前边字符和s当前字符相等或者p的字符是‘.'
                    //三种可能
                    //匹配0个，比如aa aaa*也就是没有*和*之前的字符也可以匹配上（在你（a*）没来之前我们(aa)已经能匹配上了）dp[i][j]=dp[i][j-2]
                    //匹配1个，比如aab aab* 也就是*和*之前一个字符只匹配s串的当前一个字符就不看*号了  即 dp[i][j]=dp[i][j-1]
                    //匹配多个，比如aabb aab*  b*匹配了bb两个b  那么看aab 和aab*是否能匹配上就行了，即dp[i][j]=dp[i-1][j]
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                    //如果p的*前边字符和s当前字符不相等或者p的字符不是‘.'，那就把*和*前边一个字符都不要了呗
                    //你会发现不管是这种情况还是上边的情况都会有dp[i][j]=dp[i][j-2];所以可以把下边剪枝，不用分开写了
                    //这里分开写是为了好理解
                    else if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                //其他情况肯定不能匹配上了  直接false  比如 aba abb*c
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[slen][plen];
    }

    /**
     * 递归
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        if (null == s || null == p) return false;
        if ("".equals(s) && "".equals(p)) return true;
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int s_index, String p, int p_index) {
        //如果匹配字符和正则字符同时溢出，则返回
        if (s_index >= s.length() && p_index >= p.length()) return true;
        //遇到匹配的字符没有到末尾而正则已经到末尾，则返回
        if (s_index < s.length() && p_index == p.length()) return false;
        if (p_index + 1 < p.length() && p.charAt(p_index + 1) == '*') {
            //表示s和p匹配，或者不匹配但是p是.，则进入
            // 如s = a p = .* ,s =a p =a*
            if (s_index < s.length() && (s.charAt(s_index) == p.charAt(p_index) || p.charAt(p_index) == '.')) {
                //第一个表示*匹配了0个字符
                //第二个表示匹配了1到n个字符
                return match(s, s_index, p, p_index + 2) || match(s, s_index + 1, p, p_index);
            }
            //表示*前面的字符与s的字符不匹配，也表示*匹配了0个字符
            //如s = a p = b*
            return match(s, s_index, p, p_index + 2);
        }
        //表示s和p匹配，或者不匹配但是p是.，则进入
        // 如s = a p = . ,s =a p =a
        if (s_index < s.length() && (s.charAt(s_index) == p.charAt(p_index) || p.charAt(p_index) == '.')) {
            return match(s, s_index + 1, p, p_index + 1);
        }
        //s和p不相等 s = a p = b
        return false;
    }

}
