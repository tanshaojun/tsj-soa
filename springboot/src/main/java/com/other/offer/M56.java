package com.other.offer;


public class M56 {


    /**
     * 数组中数字出现的次数
     * <p>
     * 一个整型数组里除两个数字之外，其他数字都出现了两次，请找出这两个只出现一次的数字
     *
     * @param arr
     * @return
     */
    public int[] findNumsAppearOnce(int[] arr) {
        if (null == arr || 0 == arr.length) return null;

        int a = 0;
        //先把所有的值异或，由于相同的值异或为0，所以剩下的值为两个出现一次数字的异或
        for (int ar : arr) {
            a ^= ar;
        }
        //找到异或之后值的第一个1出现的位置，由于 0^1 = 1  1^1 = 0
        int b = (a ^ (a - 1)) & a;

        int c = 0;
        //再次异或
        for (int ar : arr) {
            if ((b & ar) == 0) {
                c ^= ar;
            }
        }

        return new int[]{c, c ^ a};
    }


    /**
     * 数组中唯一出现的数字
     * <p>
     * 一个整型数组里除一个数字之外，其他数字都出现了三次，请找出这只出现一次的数字
     *
     * @param arr
     * @return
     */
    public int findNumberAppearingOnce(int[] arr) {
        if (null == arr || 0 == arr.length) return 0;
        //创建一个32长度大小的数组
        int[] bitSum = new int[32];
        for (int ar : arr) {
            int t = 1;
            //把数组中数字的每个二进制相加
            for (int i = 31; i >= 0; i--) {
                if ((t & ar) != 0) {
                    bitSum[i] += 1;
                }
                t <<= 1;
            }
        }
        int res = 0;
        //如果二进制中某一位的和能被3整数，那么那个只出现一次的数字二进制是0，否则是1
        for (int i = 0; i < bitSum.length; i++) {
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }

}
