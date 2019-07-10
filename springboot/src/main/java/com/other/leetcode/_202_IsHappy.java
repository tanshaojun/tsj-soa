package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. 快乐数
 */
public class _202_IsHappy {
    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList();
        list.add(n);
        int sum = 0;
        while (true) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
            if (n == 0) {
                if (sum == 1) return true;
                if (list.contains(sum)) return false;
                n = sum;
                sum = 0;
                list.add(n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
