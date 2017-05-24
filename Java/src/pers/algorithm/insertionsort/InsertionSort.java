package pers.algorithm.insertionsort;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/22/2017
 * @Time: 22:24
 */

public class InsertionSort {
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0)
                    swap(arr, j, j-1);
                else
                    break;
            }
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
        Integer[] arr2 = SortTestHelper.generateNearlyOrderedArray(N,100);
        SortTestHelper.testSort("pers.algorithm.insertionsort.InsertionSort", arr);
        SortTestHelper.testSort("pers.algorithm.insertionsort.InsertionSort", arr2);
        boolean flag =  SortTestHelper.isSorted(arr);
        boolean flag2 =  SortTestHelper.isSorted(arr2);
        System.out.println(flag);
        System.out.println(flag2);
    }
}