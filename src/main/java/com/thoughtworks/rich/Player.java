package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;

public class Player {
    private String displayName;
    protected Dot dot;

    public Player(String displayName, Dot dot) {
        this.displayName = displayName;
        this.dot = dot;
    }

    public void move(int steps, RichMap richMap) {
        Dot destDot = richMap.nStepsAfterDot(dot, steps);
        this.dot = destDot;
        destDot.addStayingPlayer(this);
    }

    public String getDisplayName() {
        return displayName;
    }
}
