package com.other.JUC;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/10/29 13:59
 */
public class SubListDemo {



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.subList(2, 3).clear();
        System.out.println(list.size());
    }


}
