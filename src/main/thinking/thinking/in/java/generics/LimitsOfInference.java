package thinking.in.java.generics;

//: generics/LimitsOfInference.java
import thinking.in.java.typeinfo.pets.*;
import java.util.*;

public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        // f(New.map()); // Does not compile
    }
} // /:~
