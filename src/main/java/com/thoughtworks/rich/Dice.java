package com.thoughtworks.rich;

import java.util.Random;

public class Dice {
    private Random random = new Random();
    private int range;

    public Dice(int range) {
        this.range = range;
    }

    public int roll() {
        return random.nextInt(range - 1) + 1;
    }
}
