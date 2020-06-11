package com.other.offer;

public class M19 {


    /**
     * 正则表达式匹配
     * <p>
     * .表示任意一个字符
     * *表示它前面的字符可以出现任意次
     *
     * @param s
     * @param pattern
     * @return
     */
    public boolean match(String s, String pattern) {
        if (null == s || null == pattern) {
            return false;
        }
        if (s.equals(pattern)) {
            return true;
        }
        return matchCore(s, 0, pattern, 0);
    }

    private boolean matchCore(String s, int a, String pattern, int b) {
        if (a >= s.length() && b >= pattern.length()) {
            return true;
        }
        if (a >= s.length() || b >= pattern.length()) {
            return false;
        }
        boolean b1 = s.charAt(a) == pattern.charAt(b);
        if (b + 1 < pattern.length() && pattern.charAt(b + 1) == '*') {
            if (b1 || pattern.charAt(a) == '.') {
                return matchCore(s, a + 1, pattern, b + 2) //*表示出现1次
                        || matchCore(s, a + 1, pattern, b) //*表示出现多次
                        || matchCore(s, a, pattern, b + 2);//*表示出现0次
            } else {
                return matchCore(s, a, pattern, b + 2);
            }
        }

        if (b1 || pattern.charAt(b) == '.') {
            //pattern第二个字母不是*，且首字母匹配
            return matchCore(s, a + 1, pattern, b + 1);

        }
        return false;
    }

}
