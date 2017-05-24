package pers.algorithm.selectionsort2;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/22/2017
 * @Time: 15:55
 */

public class SelectionSort {
    //不允许生成实例
    private SelectionSort() {
    }

    //选择排序算法
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            //自定义swap用于交换数据
            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("pers.algorithm.selectionsort2.SelectionSort", arr);
        boolean flag =  SortTestHelper.isSorted(arr);
        System.out.println(flag);
        return;
    }
}