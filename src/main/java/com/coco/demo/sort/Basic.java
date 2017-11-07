package com.coco.demo.sort;

import java.util.Random;

/**
 * 排序基础类
 * 
 * @author zhaochuanyun
 *
 */
public abstract class Basic {

    protected int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    protected int[] getArray() {
        Random r = new Random();
        // for (int i = 0; i < array.length; i++) {
        // array[i] = r.nextInt(100 * 1000);
        // }
        return array;
    }

    protected abstract void sort(int[] array);

    protected void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // @Test
    public void test() throws Exception {
        int[] array = this.getArray();
        Long before = System.currentTimeMillis();
        this.sort(array);
        Long time = System.currentTimeMillis() - before;
        for (int i = 0; i < 9; i++) {
            System.err.printf("排序后, 第  %d 个元素: %d\n", i, array[i]);
        }
        Thread.sleep(100L);
        System.out.println("\n耗时(秒): " + time / 1000);
    }

}
