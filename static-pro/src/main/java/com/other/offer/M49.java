package com.other.offer;

import java.util.Arrays;

public class M49 {


    /**
     * 丑数
     * 我们把只包含因子2，3，5的数称作丑数,从小到大顺序求第number个丑数
     * <p>
     * 三指针
     *
     * @param number
     * @return
     */
    public int getUglyNumber(int number) {
        if (number < 0) return 0;
        int a = 1;
        int b = 1;
        int c = 1;
        int min = 1;
        for (int i = 2; i <= number; i++) {
            min = Math.min(Math.min(a * 2, b * 3), c * 5);
            if (min == a * 2) a++;
            if (min == b * 3) b++;
            if (min == c * 5) c++;
        }
        return min;
    }

    /**
     * 暴力解法
     *
     * @param number
     * @return
     */
    public int getUglyNumber1(int number) {
        if (number < 0) return 0;
        int count = 1;
        int res = 1;
        while (count < number) {
            res++;
            if (isUgly(res)) {
                count++;
            }
        }
        return res;
    }

    /**
     * 判断一个数是不是丑数
     *
     * @param number
     * @return
     */
    public boolean isUgly(int number) {
        while (number % 2 == 0) number /= 2;
        while (number % 3 == 0) number /= 3;
        while (number % 5 == 0) number /= 5;
        return number == 1;
    }


}
