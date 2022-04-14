package com.other.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1333. 餐厅过滤器
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2020/5/20 17:04
 */
public class _1333_filterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants).filter(a -> (veganFriendly == 1 ? a[2] == veganFriendly : true) && a[3] <= maxPrice && a[4] <= maxDistance)
                .sorted((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]).map(a -> a[0]).collect(Collectors.toList());
    }
}
