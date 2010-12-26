package com.chrispad.strategy;

public class ReducedDiscountSource implements DiscountSource {

    public double discount(Item item) {
        return 0.9;
    }

}
