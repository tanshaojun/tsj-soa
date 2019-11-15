package com.other.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 */
public class _929_numUniqueEmails {


    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"a.test.email+alex@leetcode.com", "test.e.mail+bob" +
                ".cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String[] split = email.split("@");
            if (split[0].contains("+")) {
                String[] split1 = split[0].split("\\+");
                String[] split2 = split1[0].split("\\.");
                String s1 = split2[0];
                for (int j = 1; j < split2.length; j++) {
                    s1 += split2[j];
                }
                String s = s1 + "@" + split[1];
                set.add(s);
            } else {
                String[] split2 = split[0].split("\\.");
                String s1 = split2[0];
                for (int j = 1; j < split2.length; j++) {
                    s1 += split2[j];
                }
                String s = s1 + "@" + split[1];
                set.add(s);
            }
        }
        return set.size();
    }
}
