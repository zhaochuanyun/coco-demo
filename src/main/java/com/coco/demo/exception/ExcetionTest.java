package com.coco.demo.exception;

public class ExcetionTest {
    public static void main(String[] args) throws Exception {
        TryCatchException test1 = new TryCatchException();
        try {
            test1.errorMethod();
            System.err.println(test1.getClass() + " : has no exception");
        } catch (Exception e) {
            System.err.println(test1.getClass() + " : has exception");
            e.printStackTrace();
        } finally {
            System.out.println("finally1");
        }

        ThrowException test2 = new ThrowException();
        try {
            test2.errorMethod();
            System.err.println(test2.getClass() + " : has no exception");
        } catch (Exception e) {
            System.err.println(test2.getClass() + " : has exception");
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("finally2");
        }
    }
}

class TryCatchException {

    void errorMethod() {
        try {
            throw new Exception("try_info");
        } catch (Exception e) {

        }
    }

}

class ThrowException {

    void errorMethod() throws Exception {
        throw new Exception("throw_info");
    }

}
