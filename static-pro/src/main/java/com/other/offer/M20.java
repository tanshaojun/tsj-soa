package com.other.offer;

public class M20 {

    /**
     * 表示数值的字符串
     * <p>
     * 表示数值的字符串遵循A[.[B]][e|EC]或者.B[e|EC]
     * A为数值的整数部分
     * B为数值的小数部分
     * C为数值的指数部分
     * <p>
     * 在小数里面可能没有整数部分 如.123
     *
     * @param s
     * @return
     */
    public boolean isNumeric(String s) {
        if (null == s || 0 == s.length()) {
            return false;
        }
        int len = s.length();
        int index = 0;
        //这个是判断e或者E前面是否有数值
        boolean flag = false;
        //判断开始的符号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        //判断整数部分
        while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
            flag = true;
        }
        //判断小数部分
        if (index < len && s.charAt(index) == '.') {
            boolean f = false;
            index++;
            while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
                flag = true;
                f = true;
            }
            //如果.的前面没有数字，则后面必须要数字
            if (!flag && !f) {
                return false;
            }
        }
        //判断指数部分
        //当E或者e的前面没有整数时，不能表示数值
        //当E或者e的后面没有整数时，不能表示数值
        if (index < len && (s.charAt(index) == 'e' || s.charAt(index) == 'E') && flag) {
            index++;
            //判断指数部分的正负号 比如123.45e+6
            if (index < len && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                index++;
            }
            while (index < len && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
        }
        return index == s.length();
    }

}
