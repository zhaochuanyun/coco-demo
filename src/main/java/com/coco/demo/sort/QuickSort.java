package com.coco.demo.sort;

/**
 * 快速排序
 * 
 * @author zhaochuanyun
 *
 */
public class QuickSort extends Basic {

    @Override
    protected void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 递归操作
     */
    public void quickSort(int[] array, int low, int high) {
        int pivotIndex;
        if (low < high) {
            pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * 分割操作（选取一个关键字,让左边的都比关键字小,右边的比关键字大）﻿﻿
     */
    public int partition(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] array = { 6, 5, 4, 3, 2, 1 };
        QuickSort qs = new QuickSort();
        qs.sort(array);
        System.out.println(array);
    }

}
