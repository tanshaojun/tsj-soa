package com.other.leetcode;

public class isLongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        if (name == typed) return true;
        if (name.length() > typed.length() || name.charAt(0) != typed.charAt(0) || name.charAt(name.length() - 1) !=
                typed.charAt(typed.length() - 1))
            return false;
        int i = 0, j = 0, prev = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                prev = i;
                i++;
                j++;
            } else if (typed.charAt(j) == name.charAt(prev)) {
                j++;
            } else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeeed", "ssaaeeeeedd"));
    }
}
