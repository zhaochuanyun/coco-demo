package com.coco.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.common.base.Objects;

@SuppressWarnings(value = { "rawtypes", "unchecked" })
public class ReflectTest {

    public static String toString(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getSimpleName() + " [");

        for (Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            if (!sb.toString().endsWith("[")) {
                sb.append(", ");
            }

            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                try {
                    sb.append(fields[i].getName() + " = " + fields[i].get(obj));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (i != fields.length - 1) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static Car initByDefaultConst() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        Class clazz = loader.loadClass("com.coco.demo.reflect.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        Method toString = clazz.getMethod("toString");
        checkReturnType(setBrand);
        checkReturnType(toString);

        setBrand.invoke(car, "Audi");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.err.println(field.getName());
        }

        return car;
    }

    public static void checkReturnType(Method method) {
        if (Objects.equal(method.getReturnType().getName(), "void")) {
            System.out.println(method.getName() + " is void method.");
        } else {
            System.out.println(method.getName() + " is " + method.getReturnType().getSimpleName() + " method.");
        }
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }

}
