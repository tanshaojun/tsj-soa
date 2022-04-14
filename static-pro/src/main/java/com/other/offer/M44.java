package com.other.offer;

public class M44 {


    /**
     * 数字序列中某一位的数字
     *
     * @param index
     * @return
     */
    public int digitAtIndex(int index) {
        if (index < 0) return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (numbers * digits > index) {
                int start = digits == 1 ? 0 : (int) (Math.pow(10, digits - 1));
                int cur = start + index / digits;
                int i = digits - index % digits;
                for (int j = 1; j < i; j++) {
                    cur /= 10;
                }
                return cur % 10;
            }
            index -= numbers * digits;
            digits++;
        }
    }

    /**
     * 输入一个数字，得到该n位的数字一共有多少个
     *
     * @param n
     * @return
     */
    private int countOfIntegers(int n) {
        return n == 1 ? 10 : (int) (9 * Math.pow(10, n - 1));
    }

}
