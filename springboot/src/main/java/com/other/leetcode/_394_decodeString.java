package com.other.leetcode;

/**
 * 394. 字符串解码
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/28 9:47
 */
public class _394_decodeString {

    /**
     * 递归
     *
     * @param s
     * @return
     */
    public String decodeString1(String s) {
        if (null == s) return null;
        return decode(s, 0).str;
    }

    private ReturnData decode(String s, int index) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                ReturnData returnData = decode(s, i + 1);
                while (num > 0) {
                    sb.append(returnData.str);
                    num--;
                }
                i = returnData.index;
                continue;
            } else if (s.charAt(i) == ']') {
                return new ReturnData(sb.toString(), i);
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return new ReturnData(sb.toString(), 1);
    }

    public class ReturnData {
        private String str;
        private Integer index;

        public ReturnData(String str, Integer index) {
            this.str = str;
            this.index = index;
        }
    }

}
