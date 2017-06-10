package com.coco.demo.sort;

/**
 * 插入排序
 * 
 * @author zhaochuanyun
 *
 */
public class InsertSort extends Basic {

    @Override
    protected void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    this.swap(array, j - 1, j);
                }
            }
        }
    }

}
