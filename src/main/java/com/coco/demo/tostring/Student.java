package com.coco.demo.tostring;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [name=").append(name).append(", age=").append(age).append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        List<Student> list = Lists.newArrayList();

        Student student1 = new Student();
        student1.setAge(1);
        student1.setName("Student1");

        Student student2 = new Student();
        student2.setAge(2);
        student2.setName("Student2");

        Student student3 = new Student();
        student3.setAge(3);
        student3.setName("Student3");

        list.add(student3);
        list.add(student2);
        list.add(student1);

        Collections.shuffle(list);

        for (Student student : list) {
            System.out.println(student);
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getAge() < s2.getAge() ? -1 : (s1.getAge() == s2.getAge() ? 0 : 1);
            }
        });

        for (Student student : list) {
            System.out.println(student);
        }
    }

}
