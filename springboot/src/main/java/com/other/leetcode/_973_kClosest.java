package com.other.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 973. 最接近原点的 K 个点
 */
public class _973_kClosest {
    public static int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] tmp = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            tmp[i] = x * x + y * y;
            if (map.get(tmp[i]) == null) {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                map.put(tmp[i], list);
            } else {
                List<int[]> ints = map.get(tmp[i]);
                ints.add(point);
                map.put(tmp[i], ints);
            }
        }
        Arrays.sort(tmp);
        int[][] r = new int[K][2];
        int sum = 0;
        for (int i = 0; i < K; i++) {
            List<int[]> ints = map.get(tmp[i]);
            int count = 0;
            while (count < ints.size()) {
                r[sum] = ints.get(count++);
                sum++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }
}
