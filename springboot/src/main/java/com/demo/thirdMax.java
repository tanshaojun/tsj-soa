package com.demo;

public class thirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{Integer.MIN_VALUE, 1, 1}));

    }

    public static int thirdMax(int[] nums) {
        int o = Integer.MIN_VALUE;
        int t = Integer.MIN_VALUE;
        int f = Integer.MIN_VALUE;
        boolean fb = false;
        boolean fba = false;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > o) {
                int tmp = o;
                o = num;
                num = tmp;
                if (num > t) {
                    int tmp1 = t;
                    t = num;
                    num = tmp1;
                    if (num > f) {
                        fb = true;
                        f = num;
                    }
                }
            } else if (o > num) {
                if (num > t) {
                    int tmp1 = t;
                    t = num;
                    num = tmp1;
                    if (num > f) {
                        fb = true;
                        f = num;
                    }
                } else if (t > num) {
                    if (num > f) {
                        f = num;
                    }
                    if (f == Integer.MIN_VALUE) {
                        fb = true;
                    }
                } else {
                    if (num == Integer.MIN_VALUE) {
                        fba = true;
                    }
                }
            } else {
                if (num == Integer.MIN_VALUE) {
                    fba = true;
                }
            }
        }
        if (t == Integer.MIN_VALUE) {
            return o;
        } else {
            if (fba) {
                return Integer.MIN_VALUE;
            }
        }
        return f == Integer.MIN_VALUE && !fb ? o : f;
    }
}
