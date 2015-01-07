package com.thoughtworks.rich.event;

import com.thoughtworks.rich.Player;
import com.thoughtworks.rich.dots.Land;
import com.thoughtworks.rich.io.IO;

public class EventfulLand extends EventfulDot<Land> {
    public EventfulLand(Land land) {
        super(land);
    }

    @Override
    public void handleEvent(Player player) {
        IO io = IO.getInstance();
        io.print("是否要购买本房产，花费" + dot.getPrice() + "元");
        String line = io.nextLine();
        if ("Y".equals(line)) {
            io.print("你已经购得" + dot.getNo() + "号房产，花费" + dot.getPrice() + "元");
        }
    }
}
