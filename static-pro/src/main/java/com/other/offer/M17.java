package com.other.offer;

public class M17 {


    /**
     * 打印从1到最大的n位数
     *
     * @param n
     */
    public void print1ToMaxOfNDigits(int n) {
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = n - 1; i >= 0; i--) {
            while (number[i] != '9') {
                int j = 0;
                number[j]++;
                while (j < n - 1 && number[j] > '9') {
                    number[j] = '0';
                    number[j + 1]++;
                    j++;
                }
                printNumber(number);
            }
        }

    }

    private void printNumber(char[] c) {
        int len = c.length - 1;
        while (c[len] == '0') {
            len--;
        }
        for (int i = len; i >= 0; i--) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}
