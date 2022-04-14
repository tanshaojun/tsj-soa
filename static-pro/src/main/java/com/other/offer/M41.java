package com.other.offer;

import java.util.PriorityQueue;
import java.util.Scanner;

public class M41 {

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入一个正整数：");
            int cur = input.nextInt();
            System.out.println("此时的中位数是：" + getMid(cur));
        }
    }


    static PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    /**
     * 数据流中的中位数
     *
     * @return
     */
    public static int getMid(int cur) {
        int maxSize = max.size();
        int minSize = min.size();
        if (minSize == 0) {
            min.add(cur);
            return cur;
        }
        if (maxSize == 0) {
            if (min.peek() < cur) {
                max.add(min.poll());
                min.add(cur);
            } else {
                max.add(cur);
            }
            return (min.peek() + max.peek()) / 2;
        }
        if (cur > min.peek()) {
            min.add(cur);
            minSize += 1;
        } else {
            max.add(cur);
            maxSize += 1;
        }
        if (Math.abs(maxSize - minSize) >= 2) {
            if (maxSize > minSize) {
                min.add(max.poll());
            } else {
                max.add(min.poll());
            }

        }
        if ((maxSize + minSize) % 2 == 0) {
            return (min.peek() + max.peek()) / 2;
        }
        return maxSize > minSize ? max.peek() : min.peek();

    }

}
