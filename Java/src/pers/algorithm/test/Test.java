package pers.algorithm.test;

import pers.algorithm.sorttesthelper.SortTestHelper;

import java.util.Arrays;

/**
 * @Auther: zhangchao
 * @Date: 05/24/2017
 * @Time: 12:48
 */

public class Test {
    public static void main(String[] args) {
        // 测试排序算法辅助函数
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(1000000,100);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("pers.algorithm.quicksort.QuickSort", arr);
        SortTestHelper.testSort("pers.algorithm.mergesort.MergeSort", arr2);
        boolean flag = SortTestHelper.isSorted(arr);
        boolean flag2 = SortTestHelper.isSorted(arr2);
        System.out.println("quick排序是否成功: " + flag);
        System.out.println("merge排序是否成功: " + flag2);
    }
}
