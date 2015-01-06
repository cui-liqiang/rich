package com.thoughtworks.rich.dots;

public class StartDot extends Dot{
    public StartDot(int no, int x, int y) {
        super(no, x, y);
    }

    public String defaultSymbol() {
        return "S";
    }
}
