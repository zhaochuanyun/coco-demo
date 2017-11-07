//: annotations/Testable.java
package com.coco.thinking.java.annotations;

import com.coco.thinking.java.net.mindview.atunit.*;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} // /:~
