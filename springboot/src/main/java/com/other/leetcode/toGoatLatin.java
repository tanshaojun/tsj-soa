package com.other.leetcode;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/6/1017:46
 */
public class toGoatLatin {

    public static String toGoatLatin(String S) {
        StringBuffer sb = new StringBuffer("a");
        StringBuffer sb1 = new StringBuffer("");

        String[] strings = S.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            char c = string.charAt(0);
            if (c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U') {
                sb1.append(string);
                sb1.append("ma");
            } else {
                sb1.append(string.substring(1, string.length()));
                sb1.append(string.substring(0, 1));
                sb1.append("ma");
            }
            sb1.append(sb.toString());
            sb1.append(" ");
            sb.append("a");
        }
        return sb1.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("over "));
    }
}
