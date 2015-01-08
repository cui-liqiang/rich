package com.thoughtworks.rich.model.dots;

public class FinanceRoom extends Dot {
    public FinanceRoom(int no, int i) {
        super(no);
    }

    public String defaultSymbol() {
        return "$";
    }
}
