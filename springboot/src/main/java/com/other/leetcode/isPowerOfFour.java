package com.other.leetcode;


public class isPowerOfFour {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && (num & 0x66666666) == 0;
    }
}
