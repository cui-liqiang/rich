package com.thoughtworks.rich.event;

import com.thoughtworks.rich.Player;
import com.thoughtworks.rich.model.dots.Dot;

public class EventfulDot<DOT_TYPE extends Dot> {

    protected DOT_TYPE dot;

    protected EventfulDot(DOT_TYPE dot) {
        this.dot = dot;
    }

    public void handleEvent(Player player){}

    public Dot getDot() {
        return dot;
    }
}
