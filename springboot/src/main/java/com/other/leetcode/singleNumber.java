package com.other.leetcode;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        //new int[]{5}
        int r = 0;
        for (int i = 0; i < 32; ++i) {
            int count = 0;
            //bit 等于2的i次幂
            int bit = 1 << i;
            //计算每个位上1的个数
            for (int num : nums) {
                if ((num & bit) != 0)
                    count++;
            }
            //如果1的个数除3取余不等于0，则证明目标值这个位必为1
            if (count % 3 != 0)
                //列子
                // i=0 count=1;
                //r ->   000
                //bit -> 001
                //此时r = 1
                r |= bit;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{5}));
    }
}
