package com.coco.demo.dbpool;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化，模拟加载所有的配置文件
 * 
 * @author Ran
 *
 */
public class DBInitInfo {
    public static List<DBbean> beans = null;
    static {
        beans = new ArrayList<DBbean>();
        // 这里数据 可以从xml 等配置文件进行获取
        // 为了测试，这里我直接写死
        DBbean beanMySQL = new DBbean();
        beanMySQL.setDriverName("com.mysql.jdbc.Driver");
        beanMySQL.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        beanMySQL.setUserName("root");
        beanMySQL.setPassword("mvp");

        beanMySQL.setMinConnections(5);
        beanMySQL.setMaxConnections(100);

        beanMySQL.setPoolName("testPool");
        beans.add(beanMySQL);
    }
}
