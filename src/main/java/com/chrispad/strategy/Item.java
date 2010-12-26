package com.chrispad.strategy;

public class Item {

    private int price;

    public  Item(int price) {
        this.setPrice(price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
