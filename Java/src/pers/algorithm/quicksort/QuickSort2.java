package pers.algorithm.quicksort;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/24/2017
 * @Time: 13:21
 */

public class QuickSort2 {
    private QuickSort2() {
    }

    public static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        // 设定标定点
        Comparable v = arr[l];
        //arr[l+1...i]<=v;arr[j...r]>=v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) i++;
            while (j >= l + 1 && arr[j].compareTo(v) > 0) j--;
            if (i > j) break;
            swap(arr, i++, j--);
        }
        swap(arr, j, l);
        return j;
    }



    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        SortTestHelper.testSort("pers.algorithm.quicksort.QuickSort2", arr);
        boolean flag = SortTestHelper.isSorted(arr);
        System.out.println(flag);
        SortTestHelper.printArray(arr);
        return;
    }
}