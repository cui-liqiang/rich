package com.thoughtworks.rich.model.dots;

import com.thoughtworks.rich.Player;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.rich.RichMap.MAP_HEIGHT;
import static com.thoughtworks.rich.RichMap.MAP_WIDTH;

public abstract class Dot {
    protected final int no;
    private final Pos pos;
    private List<Player> players = new ArrayList<Player>();

    public Dot(int no) {
        this.no = no;
        this.pos = pos(no);
    }

    public void fillMap(String[][] map) {
        map[pos.y][pos.x] = this.toString();
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
    }

    public boolean isInclude(Player player) {
        return players.contains(player);
    }

    public void onPlayerLeave(Player player) {
        players.remove(player);
    }

    private Pos pos(int no) {
        if (no < MAP_WIDTH) {
            return new Pos(no, 0);
        } else if (MAP_WIDTH <= no && no < MAP_WIDTH + MAP_HEIGHT - 1) {
            return new Pos(MAP_WIDTH - 1, no - MAP_WIDTH + 1);
        } else if (MAP_WIDTH + MAP_HEIGHT - 1 <= no && no < MAP_WIDTH + MAP_HEIGHT - 1 + MAP_WIDTH - 1) {
            return new Pos(MAP_WIDTH + MAP_HEIGHT - 1 + MAP_WIDTH - 1 - no - 1, 7);
        } else {
            return new Pos(0, MAP_WIDTH + MAP_HEIGHT - 1 + MAP_WIDTH - 1 + MAP_HEIGHT - 1 - no - 1);
        }
    }

    public int getNo() {
        return no;
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
