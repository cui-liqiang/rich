package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;

public class Player {
    private String displayName;
    protected Dot locatingDot;

    public Player(String displayName, Dot dot) {
        this.displayName = displayName;
        dot.onPlayerEnter(this);
        this.locatingDot = dot;
    }

    public void move(int steps, RichMap richMap) {
        this.locatingDot.onPlayerLeave(this);

        Dot destDot = richMap.nStepsAfterDot(locatingDot, steps);
        destDot.onPlayerEnter(this);

        this.locatingDot = destDot;
    }

    public String getDisplayName() {
        return displayName;
    }
}
