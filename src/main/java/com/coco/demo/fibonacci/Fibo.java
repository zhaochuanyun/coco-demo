package com.coco.demo.fibonacci;

import java.math.BigDecimal;

public class Fibo {

    static BigDecimal fibo(int n) {
        if (n == 0) {
            return new BigDecimal(0);
        }
        if (n == 1) {
            return new BigDecimal(1);
        }
        return fibo(n - 2).add(fibo(n - 1));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println("fibo( " + i + " ) = " + fibo(i));
        }
    }

}
