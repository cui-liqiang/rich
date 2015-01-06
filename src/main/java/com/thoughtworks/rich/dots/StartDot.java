package com.thoughtworks.rich.dots;

public class StartDot extends Dot{
    public StartDot(int x, int y) {
        super(x, y);
    }

    public String defaultSymbol() {
        return "S";
    }
}
