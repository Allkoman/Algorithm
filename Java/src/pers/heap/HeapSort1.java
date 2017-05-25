package pers.heap;

import pers.algorithm.sorttesthelper.SortTestHelper;

/**
 * @Auther: zhangchao
 * @Date: 05/25/2017
 * @Time: 16:16
 */

public class HeapSort1 {
    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for(int i =0; i < n; i++ ){
            maxHeap.insert(arr[i]);
        }

        for(int i =n-1 ;i >= 0; i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 20;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("pers.heap.HeapSort1", arr);
        boolean flag = SortTestHelper.isSorted(arr);
        System.out.println(flag);
        return;
    }
}
