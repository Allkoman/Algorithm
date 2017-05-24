package pers.algorithm.quicksort;

import pers.algorithm.sorttesthelper.SortTestHelper;

import java.util.Arrays;

/**
 * @Auther: zhangchao
 * @Date: 05/24/2017
 * @Time: 19:07
 */

public class QuickSort3 {
    private QuickSort3() {
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;
        //partition
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        Comparable v = arr[l];

        int lt = l;  //arr[l+1...lt] < v
        int gt = r + 1; //arr[gt...r] > v
        int i = l + 1; //arr[lt+1...i) == v

        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else //arr[i] == v
                i++;
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(1000000, 100);
        SortTestHelper.testSort("pers.algorithm.quicksort.QuickSort3", arr);
        boolean flag = SortTestHelper.isSorted(arr);
        System.out.println("quick排序是否成功: " + flag);
    }

}