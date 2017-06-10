package com.coco.demo.sort;

public class BucketSort {

    /**
     * 桶式排序: 桶式排序不再是基于比较的了，它和基数排序同属于分配类的排序， 这类排序的特点是事先要知道待排 序列的一些特征。 桶式排序事先要知道待排
     * 序列在一个范围内，而且这个范围应该不是很大的。 比如知道待排序列在[0,M)内，那么可以分配M个桶，第I个桶记录I的出现情况， 最后根据每个桶收到的位置信息把数据输出成有序的形式。
     * 这里我们用两个临时性数组，一个用于记录位置信息，一个用于方便输出数据成有序方式， 另外我们假设数据落在0到MAX,如果所给数据不是从0开始，你可以把每个数减去最小的数。
     */
    private static void bucketSort(int[] data, int max) {
        int[] temp = new int[data.length];// 创建临时数组
        int[] count = new int[max];// 创建桶

        // 进桶，假如有重复的，那桶里的值为重复的次数
        for (int i = 0; i < data.length; i++) {
            count[data[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        System.arraycopy(data, 0, temp, 0, data.length);
        for (int i = data.length - 1; i > 0; i--) {
            data[--count[temp[i]]] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] keys = new int[] { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
        System.out.println("排序之前：");
        for (int i = 0; i < 10; i++) {
            System.out.print(keys[i] + ",");
        }
        bucketSort(keys, 10);// actually is 18, but 20 will also work
        System.out.println();
        System.out.println("排序之后：");
        for (int i = keys.length - 1; i > keys.length - 11; i--) {
            System.out.print(keys[i] + ",");
        }
    }

}