package com.demo;

public class twosearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4));
    }

    private static int search(int[] ints, int k) {
        int low = 0;
        int high = ints.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (k == ints[middle])
                return middle;
            else if (k < ints[middle])
                high = middle - 1;
            else low = middle + 1;
        }
        return -1;
    }


}
