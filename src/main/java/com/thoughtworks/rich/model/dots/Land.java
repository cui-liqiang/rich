package com.thoughtworks.rich.model.dots;

import com.thoughtworks.rich.Player;

public class Land extends Dot {
    private final int price;
    private Player owner;

    public Land(int no, int price) {
        super(no);
        this.price = price;
    }

    public String defaultSymbol() {
        return "0";
    }

    public int getPrice() {
        return price;
    }

    public boolean isOwnedBy(Player player) {
        return player == owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}


