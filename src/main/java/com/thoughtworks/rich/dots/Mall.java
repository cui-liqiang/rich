package com.thoughtworks.rich.dots;

public class Mall extends Dot {
    private final int minConsume;
    private final int maxConsume;

    public Mall(int no, int minConsume, int maxConsume) {
        super(no);
        this.minConsume = minConsume;
        this.maxConsume = maxConsume;
    }

    public String defaultSymbol() {
        return "Z";
    }
}
