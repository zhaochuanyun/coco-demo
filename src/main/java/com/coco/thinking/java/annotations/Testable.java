//: annotations/Testable.java
package com.coco.thinking.java.annotations;

import thinking.in.net.mindview.atunit.*;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} // /:~
