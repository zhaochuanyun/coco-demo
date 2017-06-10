package com.coco.demo.clone;

import java.io.Serializable;

@SuppressWarnings("serial")
public class House implements Serializable {

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return this.price;
    }

}
