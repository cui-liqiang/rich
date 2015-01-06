package com.thoughtworks.rich.dots;

import java.util.ArrayList;
import java.util.List;

public abstract class Dot {
    private final int x;
    private final int y;
    private List<Player> players = new ArrayList<Player>();

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fillMap(String[][] map) {
        map[x][y] = this.toString();
    }

    public void addStayingPlayer(Player player) {
        players.add(player);
    }

    abstract public String defaultSymbol();

    @Override
    public String toString() {
        if(players.isEmpty()) {
            return defaultSymbol();
        }
        return players.get(players.size() - 1).getDisplayName();
    }
}
