package com.coco.thinking.java.reusing;

//: reusing/Cartoon.java
// Constructor calls during inheritance.
import static com.coco.thinking.java.net.mindview.util.Print.*;

class Art {
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        print("Drawing constructor");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        print("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
} /*
   * Output: Art constructor Drawing constructor Cartoon constructor
   */// :~
