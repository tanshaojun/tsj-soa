package com.other.leetcode;

/**
 * 43. 字符串相乘
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/8/13 14:27
 */
public class _43_multiply {

    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || "0".equals(num1) || "0".equals(num2)) return "0";
        int size = 0;
        String sum = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            sum = add(sum, multiply(num1, num2.charAt(i) - '0', size));
            size++;
        }
        return sum;
    }

    public String multiply(String num1, int num2, int size) {
        StringBuffer sb = new StringBuffer();
        int t = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = (num1.charAt(i) - '0') * num2 + t;
            t = a / 10;
            sb.append(a % 10);
        }
        if (t != 0) sb.append(t);
        sb = sb.reverse();
        for (int i = 0; i < size; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    public String add(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int t = 0;
        StringBuffer sb = new StringBuffer();
        while (len1 >= 0 && len2 >= 0) {
            int i = (num1.charAt(len1) - '0') + (num2.charAt(len2) - '0') + t;
            t = i / 10;
            sb.append(i % 10);
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            int i = (num1.charAt(len1) - '0') + t;
            t = i / 10;
            sb.append(i % 10);
            len1--;
        }
        while (len2 >= 0) {
            int i = (num2.charAt(len2) - '0') + t;
            t = i / 10;
            sb.append(i % 10);
            len2--;
        }
        if (t > 0) sb.append(t);
        return sb.reverse().toString();
    }

}
