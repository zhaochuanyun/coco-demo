//: enumerated/menu/Course.java
package com.coco.thinking.java.enumerated.menu;

import com.coco.thinking.java.net.mindview.util.*;

public enum Course {
    APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(Food.Dessert.class), COFFEE(
            Food.Coffee.class);
    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
} // /:~
