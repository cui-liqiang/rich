package com.thoughtworks.rich.dots;

public class Land extends Dot {
    private final int price;

    public Land(int no, int price) {
        super(no);
        this.price = price;
    }

    public String defaultSymbol() {
        return "0";
    }

    public int getPrice() {
        return price;
    }
}


