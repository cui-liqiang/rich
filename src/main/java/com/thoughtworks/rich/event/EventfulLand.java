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
        if(player.canBuyLand(dot)) {
            askToBuy(player, io);
        } else {
            io.println("没有足够的余额，无法购买该土地");
        }
    }

    private void askToBuy(Player player, IO io) {
        io.println("是否要购买本房产，花费" + dot.getPrice() + "元");
        String line = io.nextLine();
        if ("Y".equals(line)) {
            player.buyLand(dot);
            io.println("你已经购得" + dot.getNo() + "号房产，花费" + dot.getPrice() + "元");
        }
    }
}
