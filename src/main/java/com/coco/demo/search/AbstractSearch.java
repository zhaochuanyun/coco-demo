package com.coco.demo.search;

public abstract class AbstractSearch {

    protected int[] array = { 1, 2, 3, 4, 5, 6 };
    protected int[] array1 = { 6, 1, 2, 3, 4, 5 };
    protected int[] array2 = { 5, 6, 1, 2, 3, 4 };
    protected int[] array3 = { 4, 5, 6, 1, 2, 3 };
    protected int[] array4 = { 3, 4, 5, 6, 1, 2 };
    protected int[] array5 = { 2, 3, 4, 5, 6, 1, };

    protected abstract int search(int[] array, int tar);

    String printArray(int[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i : array) {
            sb.append(" " + i + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    protected void testSearch(int[] array, int tar) {
        System.err.println(tar + " 在数组 " + printArray(array) + " 的位置为：" + search(array, tar));
    }

}
