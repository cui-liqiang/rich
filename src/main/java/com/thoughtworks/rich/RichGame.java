package com.thoughtworks.rich;

import com.thoughtworks.rich.event.Eventful;
import com.thoughtworks.rich.io.IO;

public class RichGame {
    public static final String QUIT_COMMAND = "quit";
    private static final String WORD_COMMAND = "work";
    private Dice dice;
    private RichMap richMap = new RichMap();

    public RichGame(Dice dice) {
        this.dice = dice;
    }

    public void run() {
        System.out.println(richMap.mapString());
        Player player = new Player("A", richMap.startingPoint());

        IO io = IO.getInstance();

        String command;
        while(!"".equals(command = io.nextLine())) {
            if(QUIT_COMMAND.equals(command)) {
                System.out.println("游戏结束");
                break;
            }
            if(WORD_COMMAND.equals(command)) {
                work(player, richMap);
            }
            System.out.println("(after executing command: " + command + ")");
            System.out.println(richMap.mapString());
        }
    }

    private void work(Player player, RichMap richMap) {
        int steps = dice.roll();
        player.move(steps, richMap);
        ((Eventful)player.locatingDot).trigger(player);
    }
}
