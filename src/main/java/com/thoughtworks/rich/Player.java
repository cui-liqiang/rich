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

    public String getDisplayName() {
        return displayName;
    }

    public void moveTo(Dot dot) {
        this.locatingDot.onPlayerLeave(this);
        this.locatingDot = dot;
        dot.onPlayerEnter(this);
    }
}
