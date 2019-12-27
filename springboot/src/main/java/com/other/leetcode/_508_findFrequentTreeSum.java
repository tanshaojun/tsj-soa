package com.other.leetcode;

import com.other.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 *
 * @author tanshaojun
 * @version 1.0
 * @date 2019/12/27 16:26
 */
public class _508_findFrequentTreeSum {

    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (null == root) return new int[]{};
        Map<Integer, Integer> map = new HashMap<>(16);
        add(map, root);
        List<Integer> tmp = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                tmp.add(entry.getKey());
            }
        }
        int[] res = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;

    }

    private Integer add(Map<Integer, Integer> map, TreeNode root) {
        if (null == root) return 0;
        Integer sum = add(map, root.left) + add(map, root.right) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }

}
