package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RichMap {
    public final static int MAP_WIDTH = 29;
    public final static int MAP_HEIGHT = 8;
    List<Dot> dots = new ArrayList<Dot>();

    public RichMap() {
        int no = 0;

        dots.add(new StartDot(no++));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));
        dots.add(new Land(no++, 200));

        dots.add(new Hospital(no++));

        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));
        dots.add(new Land(no++, 400));

        dots.add(new Mall(no++, 0, 30));

        dots.add(new Land(no++, 600));
        dots.add(new Land(no++, 600));
        dots.add(new Land(no++, 600));
        dots.add(new Land(no++, 600));
        dots.add(new Land(no++, 600));
        dots.add(new Land(no++, 600));

        dots.add(new Mall(no++, 0, 50));

        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));
        dots.add(new Land(no++, 800));

        dots.add(new ChinaListening(no++));

        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));
        dots.add(new Land(no++, 1000));

        dots.add(new Audit(no++));

        dots.add(new FinanceRoom(no++, 30));
        dots.add(new FinanceRoom(no++, 50));
        dots.add(new FinanceRoom(no++, 80));
        dots.add(new FinanceRoom(no++, 80));
        dots.add(new FinanceRoom(no++, 50));
        dots.add(new FinanceRoom(no, 30));
    }

    public String mapString() {
        String[][] map = blankMap();
        fill(map);
        return toString(map);
    }

    private String toString(String[][] map) {
        String mapString = "";
        for (String[] row : map) {
            mapString += toRowString(row);
        }
        return mapString;
    }

    private String toRowString(String[] rows) {
        String rowString = "";
        for (String dot : rows) {
            rowString += dot;
        }
        return rowString + "\n";
    }

    private void fill(String[][] map) {
        for (Dot dot : dots) {
            dot.fillMap(map);
        }
    }

    private String[][] blankMap() {
        String map[][] = new String[MAP_HEIGHT][MAP_WIDTH];
        for (String[] row : map) {
            Arrays.fill(row, " ");
        }
        return map;
    }

    public Dot startingDot() {
        return dotAt(0);
    }

    public Dot dotAt(int pos) {
        return dots.get(pos);
    }

    public Dot nStepsAfterDot(Dot current, int steps) {
        for (int i = 0; i < dots.size(); i++) {
            if (dots.get(i) == current) {
                return dots.get(((i + steps) % dotsNum()));
            }
        }
        throw new IllegalArgumentException("locatingDot " + current.toString() + " is not in the map");
    }

    private int dotsNum() {
        return (MAP_HEIGHT + MAP_WIDTH) * 2 - 4;
    }

}
