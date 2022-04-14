package com.other.leetcode;

/**
 * 1185. 一周中的第几天
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/1/3 17:24
 */
public class _1185_dayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] strings = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int index = day + 4;
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                index = (366 + index) % 7;
            } else {
                index = (365 + index) % 7;
            }
        }
        for (int i = 1; i < month; i++) {
            index = (months[i - 1] + index) % 7;
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                index++;
            }
        }
        return strings[index % 7];
    }

}
