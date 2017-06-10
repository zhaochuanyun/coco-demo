package com.coco.demo.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.collect.Maps;

/**
 * HashMap ConcurrentHashMap的介绍，参考地址
 * 
 * @see http://alex09.iteye.com/blog/539545
 * @see http://blog.csdn.net/mydreamongo/article/details/8960667
 * @see http://www.iteye.com/topic/344876
 * @author zhaochuanyun379
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConcurrentHashMapTest {

    private static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws InterruptedException {
        Map hashMap = Maps.newHashMap();
        Map hashTable = new Hashtable();
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        Map concurrentMap = new ConcurrentHashMap();

        hashMap.put(null, null);// HashMap的key和value都可以为null
        // hashTable.put(null, "HashTable的key和value均不能为null");// HashTable的key和value都不可以为null
        synchronizedMap.put(null, null);// synchronizedMap的key和value都可以为null
        // concurrentMap.put(null, "ConcurrentHashMap的key和value均不能为null");// ConcurrentHashMap的key和value都不可以为null

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < MAX_VALUE; i++) {
            executor.submit(new MapThread(hashMap, i));
            executor.submit(new MapThread(hashTable, i));
            executor.submit(new MapThread(synchronizedMap, i));
            executor.submit(new MapThread(concurrentMap, i));
        }
        Thread.sleep(100);

        check(hashMap);
        check(hashTable);
        check(synchronizedMap);
        check(concurrentMap);
    }

    static void check(Map map) {
        boolean result = true;
        for (int i = 0; i < MAX_VALUE; i++) {
            if (map.containsKey(i)) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        if (!result) {
            System.err.println(map.getClass().toString() + " : thead unsafe");
        } else {
            System.out.println(map.getClass().toString() + " : thead safe");
        }
    }
}

@SuppressWarnings({ "rawtypes", "unchecked" })
class MapThread implements Runnable {
    private Map map;
    private int index;

    public MapThread(Map map, int index) {
        this.map = map;
        this.index = index;
    }

    @Override
    public void run() {
        this.map.put(index, ":" + index);
    }

}
