package com.other.offer;

public class M15 {


    /**
     * 二进制中1的个数
     * <p>
     * 请实现一个函数，输入一个整数，输出该二进制表示中1的个数
     * <p>
     * n = 111111111111
     * 1=00000000001
     * 如果最后一位为1 那么&之后就是1，否则为0，相加即可。
     * >>右移 整数高位补0 负数补1
     * >>>无符号右移  高位都补0
     * 不用>>而用>>>是为了兼容负数
     *
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;

    }

    /**
     * 二进制中1的个数
     * <p>
     * 可以更快速的计算,比如下面的列子
     * <p>
     * n = 9
     * n    1001
     * n-1  1000
     * n&(n-1)  1000 & 1001 =1000
     * n    1000
     * n-1  0111
     * n = 0
     *
     * @param n
     * @return
     */
    public int numberOf11(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = (n - 1) & n;
        }
        return res;
    }


}
