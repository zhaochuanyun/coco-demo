package com.coco.demo.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java foreach语法操作集合时，集合是只读的，对对象元素的更改操作无效
 * 
 * @author zhaochuanyun379
 *
 */
public class TestForeach {

    public static void main(String[] args) {
        List<Area> list = new ArrayList<Area>();
        list.add(new Area("AA"));
        list.add(new Area("BB"));
        System.out.println("-----list.add(new Area(AA));list.add(new Area(BB));-----" + list);

        for (Area area : list) {
            area = new Area("CC");
        }
        System.out.println("-----for (Area area : list) {area = new Area(CC);}-----" + list);

        Iterator<Area> iter = list.iterator();
        while (iter.hasNext()) {
            Area area = iter.next();
            area = new Area("DD");
        }
        System.out.println("-----while (iter.hasNext()) {Area area = iter.next();area = new Area(DD)}-----" + list);

        Iterator<Area> iter1 = list.iterator();
        for (int i = 0; iter1.hasNext(); i++) {
            iter1.next();
            list.set(i, new Area("EE"));
        }
        System.out.println("-----for (int i = 0; iter1.hasNext(); i++) {iter1.next();list.set(i, new Area(EE));}-----" + list);

        for (int i = 0; i < list.size(); i++) {
            Area area = list.get(i);
            area.setName("FF");
        }
        System.out.println("-----for (int i = 0; i < list.size(); i++) {Area area = list.get(i);area.setName(FF);}-----" + list);

        for (Area area : list) {
            area.setName("GG");
        }
        System.out.println("-----for (Area area : list) {area.setName(GG);}-----" + list);

    }

}
