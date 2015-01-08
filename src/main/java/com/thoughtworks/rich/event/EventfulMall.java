package com.thoughtworks.rich.event;

import com.thoughtworks.rich.model.dots.Mall;

public class EventfulMall extends EventfulDot<Mall> {
    public EventfulMall(Mall mall) {
        super(mall);
    }
}
