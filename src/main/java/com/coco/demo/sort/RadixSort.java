package com.coco.demo.sort;

import java.util.Arrays;

public class RadixSort {

    /**
     * 基数排序，默认基数radix为10
     * 
     * @data 待排数组
     * @size 数组中最大数位数
     */
    public static void radixSort(int[] data) {

        // 首先确定排序的趟数;
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        // 判断位数;
        int size = 0;
        while (max > 0) {
            max /= 10;
            size++;
        }

        int radix = 10;
        int[] temp = new int[data.length];// 用于暂存元素
        int[] count = new int[radix];// 用于计数排序
        int divide = 1;

        for (int i = 0; i < size; i++, divide *= radix) {
            System.arraycopy(data, 0, temp, 0, data.length);
            Arrays.fill(count, 0);

            for (int k = 0; k < temp.length; k++) {
                int tempKey = temp[k] / divide % radix;
                count[tempKey]++;
            }

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }

            for (int n = data.length - 1; n >= 0; n--) {
                int tempKey = temp[n] / divide % radix;
                data[--count[tempKey]] = temp[n];
            }
        }

    }

    public static void main(String[] args) {
        int[] keys = new int[] { 31, 10, 45, 15, 57, 90, 2, 6, 53, 41 };
        System.out.println("排序之前：");
        for (int i = 0; i < 10; i++) {
            System.out.print(keys[i] + ",");
        }
        radixSort(keys);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = keys.length - 1; i > keys.length - 11; i--) {
            System.out.print(keys[i] + ",");
        }
    }

}
