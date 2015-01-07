package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.*;
import com.thoughtworks.rich.event.EventfulLand;

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
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));
        dots.add(new EventfulLand(no++, 200));

        dots.add(new Hospital(no++));

        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));
        dots.add(new EventfulLand(no++, 400));

        dots.add(new Mall(no++, 0, 30));

        dots.add(new EventfulLand(no++, 600));
        dots.add(new EventfulLand(no++, 600));
        dots.add(new EventfulLand(no++, 600));
        dots.add(new EventfulLand(no++, 600));
        dots.add(new EventfulLand(no++, 600));
        dots.add(new EventfulLand(no++, 600));

        dots.add(new Mall(no++, 0, 50));

        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));
        dots.add(new EventfulLand(no++, 800));

        dots.add(new ChinaListening(no++));

        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));
        dots.add(new EventfulLand(no++, 1000));

        dots.add(new Audit(no++));

        dots.add(new FinanceRoom(no++, 30));
        dots.add(new FinanceRoom(no++, 50));
        dots.add(new FinanceRoom(no++, 80));
        dots.add(new FinanceRoom(no++, 80));
        dots.add(new FinanceRoom(no++, 50));
        dots.add(new FinanceRoom(no, 30));
    }

    public String mapString() {
        String map[][] = new String[MAP_HEIGHT][MAP_WIDTH];
        for (String[] rows : map) {
            Arrays.fill(rows, " ");
        }

        for (Dot dot : dots) {
            dot.fillMap(map);
        }

        String mapStr = "";

        for (String[] rows : map) {
            for (String dot : rows) {
                mapStr += (dot);
            }
            mapStr += "\n";
        }

        return mapStr;
    }

    public Dot startingPoint() {
        return dots.get(0);
    }

    public Dot nStepsAfterDot(Dot current, int steps) {
        for (int i = 0; i < dots.size(); i++) {
            if (dots.get(i) == current) {
                return dots.get(((i + steps) % dotsNum()));
            }
        }
        throw new IllegalArgumentException("locatingDot " + current.toString() + " is not in the map");
    }

    public Dot dotAt(int pos) {
        return dots.get(pos);
    }

    private int dotsNum() {
        return (MAP_HEIGHT + MAP_WIDTH) * 2 - 4;
    }

}
