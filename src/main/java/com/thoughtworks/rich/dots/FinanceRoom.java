package com.thoughtworks.rich.dots;

public class FinanceRoom extends Dot {
    public FinanceRoom(int x, int y, int i) {
        super(x, y);
    }

    public String defaultSymbol() {
        return "$";
    }
}
