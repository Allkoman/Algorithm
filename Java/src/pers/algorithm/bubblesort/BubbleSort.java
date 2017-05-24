package pers.algorithm.bubblesort;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/23/2017
 * @Time: 10:49
 */

public class BubbleSort {
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length -i ; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j + 1);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("pers.algorithm.bubblesort.BubbleSort", arr);
        boolean flag =  SortTestHelper.isSorted(arr);
        System.out.println(flag);
    }
}