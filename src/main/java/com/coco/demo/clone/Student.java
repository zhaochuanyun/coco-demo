package com.coco.demo.clone;

import java.util.List;

import com.coco.demo.reflect.ReflectTest;

public class Student implements Cloneable {
    private int number;
    private Address addr;
    private List<House> houseList;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            stu = (Student) super.clone();
            if (addr != null) {
                stu.addr = (Address) addr.clone();
            }
            if (houseList != null) {
                stu.houseList = (List) CollectionCloningTest.deepCopy(houseList);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }

    @Override
    public String toString() {
        return ReflectTest.toString(this);
    }

}