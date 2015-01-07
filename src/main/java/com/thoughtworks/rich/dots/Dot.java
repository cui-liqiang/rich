package com.thoughtworks.rich.dots;

import com.thoughtworks.rich.Player;
import com.thoughtworks.rich.RichMap;

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

    public Dot(int no) {
        this.no = no;
        this.x = getPos().x;
        this.y = getPos().y;
    }

    public void fillMap(String[][] map) {
        map[y][x] = this.toString();
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

    private Pos getPos() {
        if (no < RichMap.MAP_WIDTH) {
            return new Pos(no, 0);
        } else if (RichMap.MAP_WIDTH <= no && no < RichMap.MAP_WIDTH + RichMap.MAP_HEIGHT - 1) {
            return new Pos(RichMap.MAP_WIDTH - 1, no - RichMap.MAP_WIDTH + 1);
        } else if (RichMap.MAP_WIDTH + RichMap.MAP_HEIGHT - 1 <= no && no < RichMap.MAP_WIDTH + RichMap.MAP_HEIGHT - 1 + RichMap.MAP_WIDTH - 1) {
            return new Pos(RichMap.MAP_WIDTH + RichMap.MAP_HEIGHT - 1 + RichMap.MAP_WIDTH - 1 - no - 1, 7);
        } else {
            return new Pos(0, RichMap.MAP_WIDTH + RichMap.MAP_HEIGHT - 1 + RichMap.MAP_WIDTH - 1 + RichMap.MAP_HEIGHT - 1 - no - 1);
        }
    }

    private static class Pos {
        public final int x;
        public final int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
