package com.coco.demo.sort;

/**
 * 堆排序
 * 
 * @author zhaochuanyun
 *
 */
public class HeapSort extends Basic {

    @Override
    protected void sort(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            this.heapAdjust(array, i, array.length - 1);
        }
        for (int i = array.length - 1; i > 0; i--) {
            this.swap(array, 0, i);
            this.heapAdjust(array, 0, i - 1);
        }
    }

    void heapAdjust(int[] array, int start, int end) {
        int tmp, childIndex;
        for (tmp = array[start]; leftChildIndex(start) <= end; start = childIndex) {
            childIndex = leftChildIndex(start);
            if (childIndex <= end - 1 && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            if (tmp < array[childIndex]) {
                array[start] = array[childIndex];
            } else {
                break;
            }
        }
        array[start] = tmp;
    }

    int leftChildIndex(int index) {
        return 2 * index + 1;
    }

}
