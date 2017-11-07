package com.coco.thinking.java.generics;

//: generics/ExplicitTypeSpecification.java
import com.coco.thinking.java.typeinfo.pets.*;
import com.coco.thinking.java.net.mindview.util.*;

import java.util.*;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>> map());
    }
} // /:~
