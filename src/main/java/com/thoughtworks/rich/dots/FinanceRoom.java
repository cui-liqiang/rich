package com.thoughtworks.rich.dots;

public class FinanceRoom extends Dot {
    public FinanceRoom(int x1, int x, int y, int i) {
        super(0, x, y);
    }

    public String defaultSymbol() {
        return "$";
    }
}
