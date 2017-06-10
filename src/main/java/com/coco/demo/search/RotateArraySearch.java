package com.coco.demo.search;

import org.junit.Test;

/**
 * 旋转有序数组的二分查找
 * 
 * @See http://www.cnblogs.com/kaituorensheng/p/3687583.html
 * @author zhaochuanyun
 *
 */
public class RotateArraySearch extends AbstractSearch {

    @Override
    protected int search(int[] array, int tar) {
        int start = 0, mid = 0;
        int end = array.length - 1;

        while (start <= end) {
            mid = (start + end) / 2;

            if (tar == array[mid]) {
                return mid;
            }

            if (array[start] <= array[mid]) {// 注意这个地方的等于号
                if (tar < array[mid] && tar >= array[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (tar <= array[end] && tar > array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }

    @Test
    public void test() {
        for (int i = 0; i < 8; i++) {
            testSearch(array3, i);
        }
    }

}
