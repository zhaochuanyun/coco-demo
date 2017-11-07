package com.coco.thinking.java.holding;

//: holding/StackTest.java
import com.coco.thinking.java.net.mindview.util.*;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
} /*
   * Output: fleas has dog My
   */// :~
