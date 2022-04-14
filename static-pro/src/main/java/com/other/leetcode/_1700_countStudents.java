package com.other.leetcode;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * @Author tansj
 * @Date 2021-05-13 13:53
 * @Version 1.0
 */
public class _1700_countStudents {

    public int countStudents(int[] students, int[] sandwiches) {
        int[] tmp = new int[2];
        for (int student : students) {
            tmp[student]++;
        }
        for (int sandwich : sandwiches) {
            if (tmp[sandwich] > 0) {
                tmp[sandwich]--;
            } else {
                break;
            }
        }
        return tmp[0] + tmp[1];
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        int len = students.length;
        int startIndex = 0;
        int endIndex = students.length;
        int leftIndex = 0;
        for (int i = 0; i < sandwiches.length; ) {
            if (sandwiches[i] == students[startIndex]) {
                len--;
                i++;
                if (++startIndex == endIndex) {
                    endIndex = leftIndex;
                    startIndex = 0;
                    leftIndex = 0;
                }
                continue;
            }
            int count = 0;
            while (sandwiches[i] != students[startIndex]) {
                if (len == ++count) {
                    return count;
                }
                students[leftIndex++] = students[startIndex++];
                if (startIndex == endIndex) {
                    endIndex = leftIndex;
                    startIndex = 0;
                    leftIndex = 0;
                }
            }
        }
        return 0;
    }

}
