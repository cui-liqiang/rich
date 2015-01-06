package com.thoughtworks.rich.dots;

public class Audit extends Dot {
    public Audit(int i, int x, int y) {
        super(0, x, y);
    }

    public String defaultSymbol() {
        return "J";
    }
}
