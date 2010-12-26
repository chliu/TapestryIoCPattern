package com.chrispad.strategy;

public class DefaultDiscountSource implements DiscountSource {

    public double discount(Item item) {
        return 1;
    }

}
