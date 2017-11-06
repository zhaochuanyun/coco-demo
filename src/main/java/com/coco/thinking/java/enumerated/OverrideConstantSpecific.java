package com.coco.thinking.java.enumerated;

//: enumerated/OverrideConstantSpecific.java
import static thinking.in.net.mindview.util.Print.*;

public enum OverrideConstantSpecific {
    NUT, BOLT, WASHER {
        void f() {
            print("Overridden method");
        }
    };
    void f() {
        print("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            printnb(ocs + ": ");
            ocs.f();
        }
    }
} /*
   * Output: NUT: default behavior BOLT: default behavior WASHER: Overridden method
   */// :~