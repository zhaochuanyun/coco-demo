package com.coco.demo.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @see http://www.importnew.com/10761.html
 * @author zhaochuanyun379
 *
 */
public class CollectionCloningTest {

    public static void main(String args[]) {
        // deep cloning Collection in Java
        Collection<Employee> org = new HashSet<Employee>();
        org.add(new Employee("Joe", "Manager"));
        org.add(new Employee("Tim", "Developer"));
        org.add(new Employee("Frank", "Developer"));

        // creating copy of Collection using copy constructor
        Collection<Employee> copy = new HashSet<Employee>(org.size());

        // Iterator<Employee> iterator = org.iterator();
        // while (iterator.hasNext()) {
        // copy.add(iterator.next().clone());
        // }

        copy = deepCopy(org);

        System.err.println("Original Collection " + org);
        System.err.println("Copy of Collection " + copy);

        Iterator<Employee> itr = org.iterator();
        while (itr.hasNext()) {
            itr.next().setDesignation("staff");
        }

        System.err.println("Original Collection after modification " + org);
        System.err.println("Original Collection after modification " + copy);
        // deep Cloning List in Java

    }

    @SuppressWarnings("unchecked")
    public static <T> Collection<T> deepCopy(Collection<T> src) {
        Collection<T> copy = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            copy = (Collection<T>) in.readObject();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        return copy;
    }
}

@SuppressWarnings("serial")
class Employee implements Cloneable, Serializable {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, designation);
    }

    @Override
    protected Employee clone() {
        Employee clone = null;
        try {
            clone = (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // won't happen
        }
        return clone;
    }
}