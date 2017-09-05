package com.coco.demo.invoke;

public class TestClass {
    String str = "test invoke";

    public TestClass() {
    }

    public TestClass(String str) {
        this.str = str;
    }

    public void print() {
        System.out.println(str);
    }

    public static class TestInnerClass {
        public TestInnerClass() {
        }

        String str = "test inner class invoke";

        public void innerPrint() {
            System.out.println(str);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestClass) {
            return this.str.equals(((TestClass) obj).str);
        }
        return false;
    }
}
