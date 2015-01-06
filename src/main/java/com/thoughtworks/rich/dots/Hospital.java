package com.thoughtworks.rich.dots;

public class Hospital extends Dot {
    public Hospital(int no, int x, int y) {
        super(no, x, y);
    }

    public String defaultSymbol() {
        return "Y";
    }
}
