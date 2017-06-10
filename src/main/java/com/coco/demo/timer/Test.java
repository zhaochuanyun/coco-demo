package com.coco.demo.timer;

import java.util.Date;
import java.util.Timer;

/**
 * @see http://swiftlet.net/archives/645
 * @author zhaochuanyun
 *
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new MyTask(1), 5000);// 5秒后启动任务

        MyTask secondTask = new MyTask(2);
        timer.schedule(secondTask, 1000, 3000);

        // 1秒后启动任务,以后每隔3秒执行一次线程
        Date date = new Date();
        timer.schedule(new MyTask(3), new Date(date.getTime() + 1000));

        // 以date为参数，指定某个时间点执行线程
        // timer.cancel();
        // secondTask.cancel();
        System.out.println(MyTask.getTime() + "main thread 结束!");
    }
}
