package com.coco.thinking.java.access;

//: access/ChocolateChip.java
// Can't use package-access member from example2 package.
import com.coco.thinking.java.access.dessert.*;

public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        // ! bite(); // Can't access bite
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
} /*
   * Output: Cookie constructor ChocolateChip constructor
   */// :~
