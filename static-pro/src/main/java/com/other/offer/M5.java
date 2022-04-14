package com.other.offer;

public class M5 {


    /**
     * 替换空格,请设计一个函数，把字符串中的每一个空格替换成"%20"。
     *
     * @return
     */
    public String replaceBlank(String s) {
        if (null == s || 0 == s.length()) return s;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) count++;
        }
        if (0 == count) return s;
        char[] chars = new char[s.length() + count * 2];
        int len = chars.length - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                chars[len--] = '0';
                chars[len--] = '2';
                chars[len--] = '%';
                continue;
            }
            chars[len--] = s.charAt(i);
        }
        return new String(chars);
    }

}
