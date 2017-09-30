package com.coco.demo.interview;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

public class Name {  
    
    String id;  
  
    Name(String id) {  
        this.id = id;  
    }  
  
    @Override  
    public boolean equals(Object obj) {  
        Name otherName = (Name) obj;  
        return Objects.equal(this.id, otherName.id);  
    }  
  
    @Override  
    public String toString() {  
        return this.getClass().getSimpleName() + "@" + this.id + "&" + this.hashCode();  
    }  
  
    public static void main(String[] args) {  
        Name n1 = new Name("zhao");  
        Name n2 = new Name("zhao");  
        System.err.println("n1.equals(n2) = " + n1.equals(n2));  
  
        Map<Name, Integer> map = Maps.newHashMap();  
        map.put(n1, 1);  
        map.put(n2, 2);  
  
        for (Entry<Name, Integer> entry : map.entrySet()) {  
            System.out.println(entry.getKey() + ":" + entry.getValue());  
        }  
  
        System.err.println(map.get(new Name("zhao")));  
    }  
  
}  


