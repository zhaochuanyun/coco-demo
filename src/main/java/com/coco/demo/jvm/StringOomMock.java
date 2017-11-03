package com.coco.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmn20m -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails
 * 
 * @author mvpzhao
 *
 */
public class StringOomMock {
    static String  base = "string";
    static StringBuffer str = new StringBuffer();
    public static void main(String[] args) {
        for (int i=0;i< Integer.MAX_VALUE;i++){
            base = base + base;
            str.append(base);
        }
    }
}
