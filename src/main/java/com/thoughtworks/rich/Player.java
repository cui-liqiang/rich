package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;

public class Player {
    private String displayName;
    protected Dot locatingDot;
    private int amountOfMoney;

    public Player(String displayName, Dot dot, int amountOfMoney) {
        this.displayName = displayName;
        this.amountOfMoney = amountOfMoney;
        dot.onPlayerEnter(this);
        this.locatingDot = dot;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void moveTo(Dot dot) {
        this.locatingDot.onPlayerLeave(this);
        this.locatingDot = dot;
        dot.onPlayerEnter(this);
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void consumeMoney(int price) {
        amountOfMoney -= price;
    }

    public boolean canAfford(int price) {
        return amountOfMoney >= price;
    }
}
