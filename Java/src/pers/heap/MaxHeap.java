package pers.heap;

import org.omg.CORBA.MARSHAL;

/**
 * @Auther: zhangchao
 * @Date: 05/25/2017
 * @Time: 14:09
 */

public class MaxHeap<Item extends Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    //插入元素
    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    //shiftDown判断是否有右孩子，右是否大于左，j所在是否比k的data大
    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;  //此轮循环中data[k]与data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
                j++;
            if (data[j].compareTo(data[k]) <= 0)
                break;

            swap(j, k);
            k = j;
        }
    }


    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;

        shiftDown(1);

        return ret;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax(){
        assert( count > 0 );
        return data[1];
    }

    //测试MaxHeap
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 50;
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];

    }
}