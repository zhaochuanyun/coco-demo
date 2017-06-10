//: annotations/ExtractInterface.java
// APT-based annotation processing.
package thinking.in.java.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    public String value();
} // /:~
