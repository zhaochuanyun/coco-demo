package com.coco.demo.clone;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @see http://blog.csdn.net/tounaobun/article/details/8491392
 * @see http://www.cnblogs.com/zc22/p/3484981.html
 * @see http://blog.csdn.net/qiaoidea/article/details/41277263
 * @author zhaochuanyun
 *
 */
public class Test {

    public static void main(String args[]) {
        Address addr = new Address();
        addr.setAdd("杭州市");
        
        House house1 = new House();
        house1.setPrice("18000");
        House house2 = new House();
        house2.setPrice("19000");
        List<House> housList = Lists.newArrayList();
        housList.add(house1);
        housList.add(house2);
        
        Student original = new Student();
        original.setNumber(23);
        original.setAddr(addr);
        original.setHouseList(housList);

        Student copy = (Student) original.clone();

        System.out.println("original:" + original);
        System.out.println("copy:" + copy);

        addr.setAdd("西湖区");
        housList.get(0).setPrice("20000");

        System.out.println("\noriginal:" + original);
        System.out.println("copy:" + copy);
        
        Object object = new Object();

    }

}
