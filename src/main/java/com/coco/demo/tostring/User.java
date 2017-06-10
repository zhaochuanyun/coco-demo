package com.coco.demo.tostring;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.common.collect.Lists;

public class User implements Comparable<User> {

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
        builder.append("User [name=").append(name).append(", age=").append(age).append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(User user) {
        return this.getAge() < user.getAge() ? -1 : (this.getAge() == user.getAge() ? 0 : 1);
    }

    public static void main(String[] args) {
        System.out.println("-------------ToStringBuilder-------------------------");
        User u = new User();
        u.setAge(25);
        u.setName("stephen curry");

        // 对象及其属性一行显示
        System.out.println(ToStringBuilder.reflectionToString(u));
        System.out.println(ToStringBuilder.reflectionToString(u, ToStringStyle.DEFAULT_STYLE));
        // 属性换行显示
        System.out.println(ToStringBuilder.reflectionToString(u, ToStringStyle.MULTI_LINE_STYLE));
        // 不显示属性名，只显示属性值，在同一行显示
        System.out.println(ToStringBuilder.reflectionToString(u, ToStringStyle.NO_FIELD_NAMES_STYLE));
        // 对象名称简写
        System.out.println(ToStringBuilder.reflectionToString(u, ToStringStyle.SHORT_PREFIX_STYLE));
        // 只显示属性
        System.out.println(ToStringBuilder.reflectionToString(u, ToStringStyle.SIMPLE_STYLE));

        List<User> list = Lists.newArrayList();

        User user1 = new User();
        user1.setAge(1);
        user1.setName("user1");

        User user2 = new User();
        user2.setAge(2);
        user2.setName("user2");

        User user3 = new User();
        user3.setAge(3);
        user3.setName("user3");

        list.add(user3);
        list.add(user2);
        list.add(user1);
        
        for (User user : list) {
            System.out.println(user);
        }
        
        Collections.shuffle(list);

        for (User user : list) {
            System.out.println(user);
        }

        Collections.sort(list);

        for (User user : list) {
            System.out.println(user);
        }
    }

}
