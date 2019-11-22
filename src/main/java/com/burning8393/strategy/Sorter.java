package com.burning8393.strategy;

public class Sorter {
    // 普通实现Comparable接口的方法
    public void sort(Comparable[] arr) {
        int minPos;
        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minPos]) == -1) {
                    minPos = j;
                }
            }
            swap(arr, i, minPos);
        }
    }

    // 使用策略模式
    public<T extends Comparable> void sort(T[] arr, Comparator<T> comparator) {
        int minPos;
        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = i; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minPos]) == -1) {
                    minPos = j;
                }
            }
            swap(arr, i, minPos);
        }
    }

    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
