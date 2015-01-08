package com.thoughtworks.rich.event;

import com.thoughtworks.rich.model.dots.FinanceRoom;

public class EventfulFinanceRoom extends EventfulDot<FinanceRoom> {
    public EventfulFinanceRoom(FinanceRoom financeRoom) {
        super(financeRoom);
    }
}
