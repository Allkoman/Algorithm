package pers.algorithm.selectionsort;

import pers.algorithm.sorttesthelper.SortTestHelper;

import java.util.*;

/**
 * @Auther: zhangchao
 * @Date: 05/22/2017
 * @Time: 13:14
 */

public class SelectionSortGeneric {
    private SelectionSortGeneric() {

    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试Integer
        Integer[] a = {94,52,74};
        SelectionSortGeneric.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSortGeneric.sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSortGeneric.sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        //测试类Student
        class Student implements Comparable<Student> {
            int score;
            String name;

            public Student(String name, int score) {
                this.score = score;
                this.name = name;
            }

            // 定义Student的compareTo函数
            // 如果分数相等，则按照名字的字母序排序
            // 如果分数不等，则分数高的靠前
            @Override
            public int compareTo(Student o) {
                if (this.score == o.score)
                    return this.name.compareTo(o.name);

                if (this.score < o.score)
                    return 1;

                else if (this.score > o.score)
                    return -1;

                else
                    return 0;
            }

            // 定义Student实例的打印输出方式
            @Override
            public String toString() {
                return "Student: " + this.name + " " + Integer.toString(this.score);
            }
        }

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D", 90);
        d[1] = new Student("C", 100);
        d[2] = new Student("B", 95);
        d[3] = new Student("A", 95);
        SelectionSortGeneric.sort(d);
        for (Student i : d) {
            System.out.println(i);
        }


        Integer[] array = SortTestHelper.generateRandomArray(20, 0, 100);
        for(Integer n : array){
            System.out.print(n + " ");
        }
        System.out.println();
        sort(array);
        for(Integer n : array){
            System.out.print(n + " ");
        }
    }

}