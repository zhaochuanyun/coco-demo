//: interfaces/interfaceprocessor/Apply.java
package thinking.in.java.interfaces.interfaceprocessor;

import static thinking.in.net.mindview.util.Print.*;

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }
} // /:~
