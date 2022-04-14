package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 */
public class _690_GetImportance {

    static List<Integer> list = new ArrayList<>();
    static Integer sum = 0;

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>(16);
        employees.stream().forEach(a -> {
            map.put(a.id, a);
        });
        Employee employee = map.get(id);
        getList(employee, map);
        sum += employee.importance;
        list.stream().forEach(l -> {
            sum += map.get(l).importance;
        });
        return sum;
    }


    private static void getList(Employee employee, Map<Integer, Employee> map) {
        List<Integer> subordinates = employee.subordinates;
        list.addAll(subordinates);
        subordinates.stream().forEach(e -> {
            getList(map.get(e), map);
        });
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

}


