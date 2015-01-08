package com.thoughtworks.rich.model;

import com.thoughtworks.rich.Player;
import com.thoughtworks.rich.model.dots.Dot;

public class Role {
    private final char symbol;
    private final String name;

    public Role(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public String toString() {
        return symbol + ":" + name;
    }

    public char getSymbol() {
        return symbol;
    }

    public Player createPlayer(int amountOfMoney, Dot dot) {
        return new Player(String.valueOf(symbol), dot, amountOfMoney);
    }
}
