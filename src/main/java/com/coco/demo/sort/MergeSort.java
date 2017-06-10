package com.coco.demo.sort;

/**
 * 归并排序
 * 
 * @author zhaochuanyun
 *
 */
public class MergeSort extends Basic {

    @Override
    protected void sort(int[] array) {
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    /**
     * 递归调用
     */
    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tempArray, left, center);
            mergeSort(array, tempArray, center + 1, right);
            merge(array, tempArray, left, center + 1, right);
        }
    }

    /**
     * 归并算法
     */
    private static void merge(int[] array, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        // 主循环
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                tempArray[tempPos++] = array[leftPos++];
            } else {
                tempArray[tempPos++] = array[rightPos++];
            }
        }
        // 复制剩余部分到tempArray
        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = array[rightPos++];
        }
        // 复制tempArray回原数组
        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }

}
