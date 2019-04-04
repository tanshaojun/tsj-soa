package com.other.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getImportance {

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

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 5;
        List<Integer> objects = new ArrayList<>();
        objects.add(2);
        objects.add(3);
        employee.subordinates = objects;


        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.importance = 3;
        List<Integer> objects1 = new ArrayList<>();
        employee1.subordinates = objects1;

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.importance = 3;
        List<Integer> objects2 = new ArrayList<>();
        employee2.subordinates = objects2;

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        System.out.println(getImportance(list, 1));
    }
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
