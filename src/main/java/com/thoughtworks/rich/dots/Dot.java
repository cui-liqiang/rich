package com.thoughtworks.rich.dots;

import com.thoughtworks.rich.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Dot {
    protected int no;
    private final int x;
    private final int y;
    private List<Player> players = new ArrayList<Player>();

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Dot(int no, int x, int y) {
        this.no = no;
        this.x = x;
        this.y = y;
    }

    public void fillMap(String[][] map) {
        map[x][y] = this.toString();
    }

    abstract public String defaultSymbol();

    @Override
    public String toString() {
        if(players.isEmpty()) {
            return defaultSymbol();
        }
        return players.get(players.size() - 1).getDisplayName();
    }

    public void onPlayerEnter(Player player) {
        players.add(player);
        doInDot();
    }

    protected void doInDot(){}

    public boolean isInclude(Player player) {
        return players.contains(player);
    }

    public void onPlayerLeave(Player player) {
        players.remove(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dot)) return false;

        Dot dot = (Dot) o;

        if (x != dot.x) return false;
        if (y != dot.y) return false;

        return true;
    }
}
