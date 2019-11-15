package com.other.leetcode;

/**
 * 849. 到最近的人的最大距离
 */
public class _849_maxDistToClosest {
    /**
     * 输入：[1,0,0,0,1,0,1]
     * 输出：2
     * 解释：
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     *
     * @param seats
     * @return
     */
    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (index == -1) {
                    max = index = i;
                } else {
                    int i1 = i - index;
                    int c = i1 / 2;
                    index = i;
                    if (c > max) max = c;
                }
            }
        }
        int i = seats.length - 1 - index;
        return i > max ? i : max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1, 1, 1, 0, 1, 1};
        System.out.println(maxDistToClosest(ints));
    }
}

