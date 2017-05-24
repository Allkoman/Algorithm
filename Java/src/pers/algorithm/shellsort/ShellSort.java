package pers.algorithm.shellsort;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/23/2017
 * @Time: 18:47
 */

public class ShellSort {
    private ShellSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for (; j >= h && e.compareTo(arr[j - h]) < 0; j -= h)
                    arr[j] = arr[j - h];
                arr[j] = e;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("pers.algorithm.shellsort.ShellSort", arr);
        boolean flag = SortTestHelper.isSorted(arr);
        System.out.println(flag);
        SortTestHelper.printArray(arr);
    }
}