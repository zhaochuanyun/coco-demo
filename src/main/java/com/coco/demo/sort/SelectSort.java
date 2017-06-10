package com.coco.demo.sort;

/**
 * 选择排序
 * 
 * @author zhaochuanyun
 *
 */
public class SelectSort extends Basic {

    @Override
    protected void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    this.swap(array, i, j);
                }
            }
        }
    }

}
