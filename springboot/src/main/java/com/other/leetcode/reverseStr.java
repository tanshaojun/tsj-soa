package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1020:01
 */
public class reverseStr {


    public static String reverseStr1(String s, int k) {
        StringBuffer sb = new StringBuffer("");
        int length = s.length();
        int count = length / (2 * k);
        int l = length - count * (2 * k);
        if (count == 0)
            l = length;
        else
            for (int i = 0; i < count; i++) {
                sb.append(s.substring(2 * k * i, 2 * k * i + k)).reverse();
                sb.append(s.substring(2 * k * i + k, 2 * k * i + 2 * k));
            }

        if (l <= k)
            sb.append(s.substring(count * (2 * k), length)).reverse();
        else {
            sb.append(s.substring(count * (2 * k), count * (2 * k) + k)).reverse();
            sb.append(s.substring(count * (2 * k) + k, length));
        }
        return sb.toString();
    }


    public static String reverseStr(String s, int k) {
        int length = s.length();
        int count = length / (2 * k);
        StringBuffer sb = new StringBuffer("");
        if (count == 0) {
            if (length <= k) {
                sb.append(s.substring(0, length)).reverse();
                return sb.toString();
            } else {
                sb.append(s.substring(0, k)).reverse();
                sb.append(s.substring(k, length));
                return sb.toString();
            }
        } else {
            for (int i = 0; i < count; i++) {
                StringBuffer sb1 = new StringBuffer("");
                sb1.append(s.substring(2 * k * i, 2 * k * i + k)).reverse();
                sb1.append(s.substring(2 * k * i + k, 2 * k * i + 2 * k));
                sb.append(sb1);
            }
        }
        int l = length - count * (2 * k);
        if (l <= k) {
            StringBuffer sb1 = new StringBuffer("");
            sb1.append(s.substring(count * (2 * k), length)).reverse();
            sb.append(sb1);
        } else {
            StringBuffer sb1 = new StringBuffer("");
            sb1.append(s.substring(count * (2 * k), count * (2 * k) + k)).reverse();
            sb1.append(s.substring(count * (2 * k) + k, length));
            sb.append(sb1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("a", 7));
    }
}
