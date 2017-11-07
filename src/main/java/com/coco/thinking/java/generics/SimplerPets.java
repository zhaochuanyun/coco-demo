package com.coco.thinking.java.generics;

//: generics/SimplerPets.java
import com.coco.thinking.java.typeinfo.pets.*;
import com.coco.thinking.java.net.mindview.util.*;

import java.util.*;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} // /:~
