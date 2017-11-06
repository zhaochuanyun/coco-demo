package com.coco.thinking.java.generics;

//: generics/SimplerPets.java
import thinking.in.java.typeinfo.pets.*;
import thinking.in.net.mindview.util.*;

import java.util.*;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} // /:~
