package com.tsj.common.utils;


import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 谭少军
 * @version V1.0
 * @description 描述该类是做什么的
 * @ClassName: ${type_name}
 * @Date ${date} ${time}
 * Copyright(c) 2015 www.aiwue.com  All rights reserved
 * <p>
 * ${tags}
 */
public class StringUtils {

    public static String getString(String oldString, List list) {
        String[] newString = oldString.split("%s");
        for (int i = 0; i < list.size(); i++) {
            newString[i] += list.get(i);
        }
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < newString.length; i++) {
            s = s.append(newString[i]);
        }
        return s.toString();
    }

    public static Range<Double> checkRange(String s) {
        if(s.contains("未知")){
            return null;
        }
        Range<Double> range = null;
        String[] split1 = s.split(",");
        String left = split1[0];
        char c = left.charAt(0);
        String right = split1[1];
        char i1 = right.charAt(right.length() - 1);
        String s3 = c + "" + i1;
        String rightSubstring = right.substring(0, right.length() - 1);
        String leftSubstring = left.substring(1, left.length());

        if ("()".equals(s3)) {
            boolean b1 = negativeInfinity(left);
            boolean b = plusInfinity(right);
            if (b & b1) {
                //有正无穷，有负无穷
            }else
            if ((!b) & b1) {
                //有负无穷 没正无穷
                range = Range.lessThan(Double.parseDouble(rightSubstring));
            }else
            if (b & (!b1)) {
                //有正无穷 没负无穷
                range = Range.greaterThan(Double.parseDouble(leftSubstring));
            }else
            //没有 正无穷和负无穷
            range = Range.open(Double.parseDouble(leftSubstring),Double.parseDouble(rightSubstring));

        } else if ("(]".equals(s3)) {
            boolean b1 = negativeInfinity(left);
            boolean b = plusInfinity(right);
            if (b & b1) {
                //有正无穷，有负无穷
            }else
            if ((!b) & b1) {
                //有负无穷 没正无穷
                range = Range.atMost(Double.parseDouble(rightSubstring));
            }else
            if (b & (!b1)) {
                //有正无穷 没负无穷
                range = Range.greaterThan(Double.parseDouble(leftSubstring));
            }else
            //没有 正无穷和负无穷
            range = Range.openClosed(Double.parseDouble(leftSubstring),Double.parseDouble(rightSubstring));

        } else if ("[]".equals(s3)) {
            boolean b1 = negativeInfinity(left);
            boolean b = plusInfinity(right);
            if (b & b1) {
                //有正无穷，有负无穷
            }else
            if ((!b) & b1) {
                //有负无穷 没正无穷
                range = Range.atMost(Double.parseDouble(rightSubstring));
            }else
            if (b & (!b1)) {
                //有正无穷 没负无穷
                range = Range.atLeast(Double.parseDouble(leftSubstring));
            }else
            //没有 正无穷和负无穷
            range = Range.closed(Double.parseDouble(leftSubstring),Double.parseDouble(rightSubstring));

        } else if ("[)".equals(s3)) {
            boolean b1 = negativeInfinity(left);
            boolean b = plusInfinity(right);
            if (b & b1) {
                //有正无穷，有负无穷
            }else
            if ((!b) & b1) {
                //有负无穷 没正无穷
                range = Range.lessThan(Double.parseDouble(rightSubstring));
            }else
            if (b & (!b1)) {
                //有正无穷 没负无穷
                range = Range.atLeast(Double.parseDouble(leftSubstring));
            }else
            //没有 正无穷和负无穷
            range = Range.closedOpen(Double.parseDouble(leftSubstring),Double.parseDouble(rightSubstring));

        }

        return range;
    }

    private static boolean plusInfinity(String s) {
        if (s.contains("+∞")) {
            return true;
        }
        return false;
    }

    private static boolean negativeInfinity(String s) {
        if (s.contains("-∞")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Range<Double> doubleRange = checkRange("(10,50]");
        System.out.println(doubleRange.contains(Double.parseDouble(20+"")));
    }
}
