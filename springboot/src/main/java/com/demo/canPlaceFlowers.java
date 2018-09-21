package com.demo;

public class canPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0}, 2));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = flowerbed.length;
        for (int i = 0; i < count; ) {
            if (flowerbed[i] == 1) {
                i = i + 2;
            } else {
                if (count - i > 1) {
                    int t = i;
                    while (t < count && flowerbed[t] != 1) t++;
                    int i1 = t - i;
                    if (i1 == count) {
                        int i2 = flowerbed.length / 2;
                        int i3 = flowerbed.length % 2 == 0 ? i2 : i2 + 1;
                        n = n - i3;
                    } else {
                        n = n - (i1 / 2);
                        if ((t == count && i1 >= 3)) n--;
                    }
                    i = t;
                } else {
                    n--;
                    return n <= 0;
                }
            }
        }
        return n <= 0;
    }
}
