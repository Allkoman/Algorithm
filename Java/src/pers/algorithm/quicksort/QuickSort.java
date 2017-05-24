package pers.algorithm.quicksort;

import pers.algorithm.sorttesthelper.SortTestHelper;

import java.util.Arrays;

/**
 * @Auther: zhangchao
 * @Date: 05/23/2017
 * @Time: 21:33
 */

public class QuickSort {
    private QuickSort() {
    }

    //对arr[r...l]部分进行partition操作
    //返回值为整型数据p，满足arr[l...p-1]<arr[p]; arr[p+1...r]>arr[p]
    public static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        //arr[l+1...j]<v;arr[j+1...i)>v
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(v) < 0) {
                swap(arr, ++j, i);
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
        // 测试排序算法辅助函数
        int N = 200000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("pers.algorithm.quicksort.QuickSort", arr);
        SortTestHelper.testSort("pers.algorithm.mergesort.MergeSort", arr2);
        boolean flag = SortTestHelper.isSorted(arr);
        boolean flag2 = SortTestHelper.isSorted(arr2);
        System.out.println("quick排序是否成功: " + flag);
        System.out.println("merge排序是否成功: " + flag2);
    }
}