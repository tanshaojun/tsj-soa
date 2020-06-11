package com.other.offer;

import java.util.Arrays;

public class M45 {


    /**
     * 把数组排成最小的数
     *
     * @param arr
     * @return
     */
    public String printMinNumber(String[] arr) {
        if (null == arr || 0 == arr.length) return "";
        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));
        return String.join("", arr);
    }

}
