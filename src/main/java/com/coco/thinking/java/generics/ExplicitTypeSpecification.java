package com.coco.thinking.java.generics;

//: generics/ExplicitTypeSpecification.java
import thinking.in.java.typeinfo.pets.*;
import thinking.in.net.mindview.util.*;

import java.util.*;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>> map());
    }
} // /:~
