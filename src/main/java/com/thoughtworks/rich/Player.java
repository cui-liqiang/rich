package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;
import com.thoughtworks.rich.dots.Land;

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

    public void buyLand(Land land) {
        amountOfMoney -= land.getPrice();
        land.setOwner(this);
    }

    public boolean canBuyLand(Land land) {
        return amountOfMoney >= land.getPrice();
    }
}
