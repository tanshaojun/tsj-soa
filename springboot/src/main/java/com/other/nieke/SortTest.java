package com.other.nieke;

/**
 * Created with IntelliJ IDEA
 * name tan shaojun
 * Date: 2019/6/30
 * Time: 12:29 PM
 */
public class SortTest {

    private static int minAdd(int[] ints) {
        return minAddMergeSort(ints, 0, ints.length - 1);
    }


    private static int minAddMergeSort(int[] ints, int left, int right) {
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        return minAddMergeSort(ints, left, mid) +
                minAddMergeSort(ints, mid + 1, right) +
                minAddMerge(ints, left, mid, right);
    }

    private static int minAddMerge(int[] ints, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
        int sum = 0;
        while (l <= mid && r <= right) {
            if (ints[l] < ints[r]) {
                sum = sum + ints[l] * (right - r + 1);
                tmp[i++] = ints[l++];
            } else
                tmp[i++] = ints[r++];
        }
        while (l <= mid)
            tmp[i++] = ints[l++];
        while (r <= right)
            tmp[i++] = ints[r++];
        for (int j = 0; j < tmp.length; j++)
            ints[left + j] = tmp[j];
        return sum;

    }


    public static void main(String[] args) {
        int[] ints = generateRandomArray(10, 10);
        //求小和
//        System.out.println(minAdd(ints));
        heapSort(ints);
        for (int r : ints)
            System.out.print(r + " , ");
    }


//--------------------------------排序---------------------------

    /**
     * 堆排序
     *
     * @param ints
     */
    private static void heapSort(int[] ints) {
        for (int i = 0; i < ints.length; i++)
            heapInsert(ints, i);
        int size = ints.length;
        swap(ints, 0, --size);
        while (size > 0) {
            headify(ints, 0, size);
            swap(ints, 0, --size);
        }
    }


    /**
     * 堆调整最大值
     *
     * @param ints
     * @param index
     */
    private static void heapInsert(int[] ints, int index) {
        while (ints[index] > ints[(index - 1) / 2]) {
            swap(ints, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆向下调整
     *
     * @param ints
     * @param index
     * @param size
     */
    private static void headify(int[] ints, int index, int size) {
        //左孩子的下标
        int leftIndex = 2 * index + 1;
        while (leftIndex < size) {
            int rightIndex = leftIndex + 1;
            //比较出左孩子和右孩子的值大的下标
            int maxIndex = rightIndex < size && ints[rightIndex] > ints[leftIndex] ? rightIndex : leftIndex;
            //比较出父和子比较大的下标
            maxIndex = ints[maxIndex] > ints[index] ? maxIndex : index;
            //如果大的下标就是当前父，则退出
            if (maxIndex == index) break;
            swap(ints, maxIndex, index);
            index = maxIndex;
            leftIndex = 2 * index + 1;
        }
    }

    /**
     * 快速排序
     *
     * @param ints
     * @param left
     * @param right
     */
    private static void quickSort(int[] ints, int left, int right) {
        if (left < right) {
            int i = left + (int) (Math.random() * (right - left + 1));
            swap(ints, left + ((right - left) >> 1), right);
            int[] tmp = partition(ints, left, right);
            quickSort(ints, left, tmp[0] - 1);
            quickSort(ints, tmp[1] + 1, right);
        }
    }

    private static int[] partition(int[] ints, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (ints[left] < ints[right]) {
                swap(ints, ++less, left++);
            } else if (ints[left] > ints[right]) {
                swap(ints, left, --more);
            } else {
                left++;
            }
        }
        swap(ints, more, right);
        return new int[]{less + 1, more};
    }

    /**
     * 归并排序
     *
     * @param ints
     * @param left
     * @param right
     */
    private static void mergeSort(int[] ints, int left, int right) {
        if (left == right) return;
        int mid = left + ((right - left) >> 1);
        mergeSort(ints, left, mid);
        mergeSort(ints, mid + 1, right);
        merge(ints, left, mid, right);
    }

    /**
     * 归并
     *
     * @param ints
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] ints, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right)
            tmp[i++] = ints[l] > ints[r] ? ints[l++] : ints[r++];
        while (l <= mid)
            tmp[i++] = ints[l++];
        while (r <= right)
            tmp[i++] = ints[r++];
        for (int j = 0; j < tmp.length; j++)
            ints[left + j] = tmp[j];
    }

    /**
     * 插入排序
     *
     * @param ints
     */
    private static void insertSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            for (int j = i - 1; j >= 0 && ints[j] > ints[j + 1]; j--)
                swap(ints, j, j + 1);
        }
    }

    /**
     * 冒泡排序
     *
     * @param ints
     */
    private static void bubbleSort(int[] ints) {
        if (null == ints || ints.length < 2) return;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                if (ints[i] < ints[j])
                    swap(ints, i, j);
            }
        }
    }

    /**
     * 随机数组生成器
     *
     * @param minSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int minSize, int maxValue) {
        int[] arr = new int[(int) ((minSize + 1) * Math.random()) + 5];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (maxValue * Math.random());
        return arr;
    }


    /**
     * 交换
     *
     * @param ints
     * @param i
     * @param j
     */
    private static void swap(int[] ints, int i, int j) {
//        ints[i] = ints[i] ^ ints[j];
//        ints[j] = ints[i] ^ ints[j];
//        ints[i] = ints[i] ^ ints[j];
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

}
