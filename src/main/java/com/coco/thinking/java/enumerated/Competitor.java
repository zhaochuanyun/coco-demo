//: enumerated/Competitor.java
// Switching one enum on example2.
package com.coco.thinking.java.enumerated;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
} // /:~
