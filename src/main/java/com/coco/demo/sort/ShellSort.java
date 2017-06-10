package com.coco.demo.sort;

/**
 * 希尔排序
 * 
 * @author zhaochuanyun
 *
 */
public class ShellSort extends Basic {

    @Override
    protected void sort(int[] array) {
        for (int inc = array.length / 2; inc > 0; inc /= 2) {
            for (int start = 0; start < inc; start++) {
                shellSort(array, start, inc);
            }
        }
    }

    void shellSort(int[] array, int start, int inc) {
        for (int i = start + inc; i < array.length; i += inc) {
            for (int j = i; j >= inc; j -= inc) {
                if (array[j - inc] > array[j]) {
                    this.swap(array, j - inc, j);
                }
            }
        }
    }

}
