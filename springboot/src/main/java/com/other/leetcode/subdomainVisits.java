package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subdomainVisits {
    public static void main(String[] args) {
        List<String> list = subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
                "5 wiki.org"});
        System.out.println(list);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < cpdomains.length; i++) {
            String cpdomain = cpdomains[i];
            String[] split = cpdomain.split(" ");
            String count = split[0];
            String parent = split[1];
            String[] split1 = parent.split("\\.");
            String tmp = "";
            for (int j = split1.length - 1; j >= 0; j--) {
                String s = split1[j];
                if (split1.length - 1 == j)
                    tmp = s;
                else
                    tmp = s + "." + tmp;
                aaaa(map, count, tmp);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            String key = m.getKey();
            Integer value = m.getValue();
            String s = value + " " + key;
            list.add(s);
        }
        return list;
    }

    private static void aaaa(Map<String, Integer> map, String count, String s) {
        if (map.get(s) == null) {
            map.put(s, Integer.valueOf(count));
        } else {
            Integer integer = map.get(s);
            Integer integer1 = Integer.valueOf(count);
            map.put(s, integer + integer1);
        }
    }
}
