package pers.algorithm.insertionsort;

import pers.algorithm.sorttesthelper.SortTestHelper;

import java.util.Arrays;

/**
 * @Auther: zhangchao
 * @Date: 05/22/2017
 * @Time: 23:17
 */

public class InsertionSortImp {
    private InsertionSortImp() {

    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("pers.algorithm.insertionsort.InsertionSortImp", arr);
        boolean flag = SortTestHelper.isSorted(arr);
        System.out.println(flag);
        return;
    }
}