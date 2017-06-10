package com.coco.demo.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    private int id;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public MyTask(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println(getTime() + "线程" + id + ":正在执行");
        // System.gc();
    }

    public static String getTime() {
        return "[" + sdf.format(new Date()) + "] ";
    }
}
