package com.coco.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Java的serialization提供了一种持久化对象实例的机制。当持久化对象时，可能有一个特殊的对象数据成员，我们不想
 * 用serialization机制来保存它。为了在一个特定对象的一个域上关闭serialization，可以在这个域前加上关键字transient。
 * transient是Java语言的关键字，用来表示一个域不是该对象串行化的一部分
 * 。当一个对象被串行化的时候，transient型变量的值不包括在串行化的表示中，然而非transient型的变量是被包括进去的。
 * 
 * @author zhaochuanyun
 *
 */
@SuppressWarnings("serial")
public class LoggingInfo implements java.io.Serializable {
    private Date loggingDate = new Date();
    private String uid;
    private transient String pwd;

    LoggingInfo(String user, String password) {
        uid = user;
        pwd = password;
    }

    public String toString() {
        String password = null;
        if (pwd == null) {
            password = "NOT SET";
        } else {
            password = pwd;
        }
        return "logon info: \n   " + "user: " + uid + "\n   logging date : "
                + loggingDate.toString() + "\n   password: " + password;
    }

    public static void main(String[] args) {
        LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
        System.out.println(logInfo.toString());
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("D://logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        } catch (Exception e) {
            // deal with exception
        }

        // To read the object back, we can write
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("D://logInfo.out"));
            LoggingInfo logInfo2 = (LoggingInfo) in.readObject();
            System.out.println(logInfo2.toString());
        } catch (Exception e) {
            // deal with exception
        }
    }

}