package com.coco.demo.sort;

/**
 * 冒泡排序
 * 
 * @author zhaochuanyun
 *
 */
public class BubbleSort extends Basic {

    @Override
    protected void sort(int[] array) {
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    this.swap(array, j, j - 1);
                    flag = true;
                }
            }
        }
    }

}
