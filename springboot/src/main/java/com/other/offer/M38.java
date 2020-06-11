package com.other.offer;

public class M38 {


    /**
     * 字符串的排列
     *
     * @param s
     */
    public void permutation(String s) {
        char[] arr = s.toCharArray();
        process(arr, 0);
    }

    /**
     * 每次让首字母和后面的交换
     *
     * @param arr
     * @param index
     */
    private void process(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            process(arr, index + 1);
            swap(arr, i, index);

        }
    }

    private void swap(char[] arr, int l, int r) {
        char t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

}
