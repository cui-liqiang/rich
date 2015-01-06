package com.thoughtworks.rich.dots;

public class Hospital extends Dot {
    public Hospital(int x, int y) {
        super(x, y);
    }

    public String defaultSymbol() {
        return "Y";
    }
}
