//: enumerated/Competitor.java
// Switching one enum on another.
package thinking.in.java.enumerated;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
} // /:~
