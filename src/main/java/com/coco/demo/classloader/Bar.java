package com.coco.demo.classloader;

public class Bar {

  public Bar(String a, String b) {
    System.out.println("bar! " + a + " " + b);
    new Baz(a, b);
    try {
      Class booClass = Class.forName("com.coco.demo.classloader.Boo");
      Object boo = booClass.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
