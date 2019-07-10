package com.other.leetcode;


/**
 * 342. 4的幂
 */
public class _342_IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && (num & 0x66666666) == 0;
    }
}
