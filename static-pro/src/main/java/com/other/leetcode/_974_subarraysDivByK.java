package com.other.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/27 9:51
 */
public class _974_subarraysDivByK {

    /**
     * 同余定理 (a-b) mod c == 0 等于整数 则a,b,a-b对c取余相同
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i : A) {
            sum += i;
            int m = (sum % K + K) % K;
            Integer o = map.getOrDefault(m, 0);
            res += o;
            map.put(m, o + 1);
        }
        return res;
    }

}
