package com.thoughtworks.rich.dots;

public class Mall extends Dot {
    private final int minConsume;
    private final int maxConsume;

    public Mall(int i, int x, int y, int minConsume, int maxConsume) {
        super(0, x, y);
        this.minConsume = minConsume;
        this.maxConsume = maxConsume;
    }

    public String defaultSymbol() {
        return "Z";
    }
}
