package com.other.leetcode;

/**
 * 292. Nim 游戏
 */
public class _292_CanWinNim {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
