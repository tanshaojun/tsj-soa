package com.other.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 */
public class _57_Insert {
    public static void main(String[] args) {
        Interval newInterval = new Interval(0, 7);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        List<Interval> insert = insert(intervals, newInterval);
        System.out.println(insert);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        if (intervals != null && intervals.size() > 0) {
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);
                int start = interval.start;
                int end = interval.end;
                if (start > newInterval.end) {
                    list.add(newInterval);
                    //新的在旧的左边
                    list.add(interval);
                    while (i < intervals.size() - 1) {
                        i++;
                        list.add(intervals.get(i));
                    }
                    return list;

                } else if (end < newInterval.start) {
                    //新的在旧的右边
                    list.add(interval);
                    if (i == intervals.size() - 1) {
                        list.add(newInterval);
                        return list;
                    }
                } else if ((newInterval.start >= start && end > newInterval.end) || (newInterval.start > start && end
                        >= newInterval.end)) {
                    //新的在旧的中间
                    list.add(interval);
                    while (i < intervals.size() - 1) {
                        i++;
                        list.add(intervals.get(i));
                    }
                    return list;
                } else if ((start >= newInterval.start && end < newInterval.end) || (start > newInterval.start && end
                        <= newInterval.end)) {
                    //旧的在新的中间
                    if (i == intervals.size() - 1) {
                        list.add(newInterval);
                        return list;
                    }
                } else if (newInterval.end >= start && newInterval.end < end && start > newInterval.start) {
                    //新的结尾在旧的中间，旧的开头在新的中间
                    newInterval.end = end;
                    if (i == intervals.size() - 1) {
                        list.add(newInterval);
                        return list;
                    }
                } else if (newInterval.start > start && newInterval.start <= end && end <
                        newInterval.end) {
                    //新的开头在旧的中间，旧的结尾在新的中间
                    newInterval.start = start;
                    if (i == intervals.size() - 1) {
                        list.add(newInterval);
                        return list;
                    }
                } else {
                    list.add(interval);
                    while (i < intervals.size() - 1) {
                        i++;
                        list.add(intervals.get(i));
                    }
                    return list;
                }
            }
            return list;
        }
        list.add(newInterval);
        return list;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}