//: interfaces/interfaceprocessor/Apply.java
package com.coco.thinking.java.interfaces.interfaceprocessor;

import static com.coco.thinking.java.net.mindview.util.Print.*;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} // /:~
