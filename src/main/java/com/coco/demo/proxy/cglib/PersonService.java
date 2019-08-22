package com.coco.demo.proxy.cglib;

/**
 * @see http://www.dengshenyu.com/java/2017/01/24/CGLIB-dynamic-proxy.html
 */
public class PersonService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public Integer lengthOfName(String name) {
        return name.length();
    }
}
