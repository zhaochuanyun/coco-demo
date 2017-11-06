//: annotations/database/SQLString.java
package com.coco.thinking.java.annotations.database;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;

    String name() default "";

    Constraints constraints() default @Constraints;
} // /:~
