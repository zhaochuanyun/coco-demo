package com.coco.demo.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InverseTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个整数(-1表示结束):");
            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            list.add(input);
        }

        System.out.println("这组输入数字的逆序形式是: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
