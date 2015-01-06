package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RichMap {
    private final int mapWidth;
    private final int mapHeight;
    List<Dot> dots = new ArrayList<Dot>();

    public RichMap() {
        mapWidth = 29;
        mapHeight = 8;

        dots.add(new StartDot(0, 0));
        dots.add(new Land(0, 1, 200));
        dots.add(new Land(0, 2, 200));
        dots.add(new Land(0, 3, 200));
        dots.add(new Land(0, 4, 200));
        dots.add(new Land(0, 5, 200));
        dots.add(new Land(0, 6, 200));
        dots.add(new Land(0, 7, 200));
        dots.add(new Land(0, 8, 200));
        dots.add(new Land(0, 9, 200));
        dots.add(new Land(0, 10, 200));
        dots.add(new Land(0, 11, 200));
        dots.add(new Land(0, 12, 200));
        dots.add(new Land(0, 13, 200));

        dots.add(new Hospital(0, 14));

        dots.add(new Land(0, 15, 400));
        dots.add(new Land(0, 16, 400));
        dots.add(new Land(0, 17, 400));
        dots.add(new Land(0, 18, 400));
        dots.add(new Land(0, 19, 400));
        dots.add(new Land(0, 20, 400));
        dots.add(new Land(0, 21, 400));
        dots.add(new Land(0, 22, 400));
        dots.add(new Land(0, 23, 400));
        dots.add(new Land(0, 24, 400));
        dots.add(new Land(0, 25, 400));
        dots.add(new Land(0, 26, 400));
        dots.add(new Land(0, 27, 400));

        dots.add(new Mall(0, 28, 0, 30));

        dots.add(new Land(1, 28, 600));
        dots.add(new Land(2, 28, 600));
        dots.add(new Land(3, 28, 600));
        dots.add(new Land(4, 28, 600));
        dots.add(new Land(5, 28, 600));
        dots.add(new Land(6, 28, 600));

        dots.add(new Mall(7, 28, 0, 50));

        dots.add(new Land(7, 27, 800));
        dots.add(new Land(7, 26, 800));
        dots.add(new Land(7, 25, 800));
        dots.add(new Land(7, 24, 800));
        dots.add(new Land(7, 23, 800));
        dots.add(new Land(7, 22, 800));
        dots.add(new Land(7, 21, 800));
        dots.add(new Land(7, 20, 800));
        dots.add(new Land(7, 19, 800));
        dots.add(new Land(7, 18, 800));
        dots.add(new Land(7, 17, 800));
        dots.add(new Land(7, 16, 800));
        dots.add(new Land(7, 15, 800));

        dots.add(new ChinaListening(7, 14));

        dots.add(new Land(7, 13, 1000));
        dots.add(new Land(7, 12, 1000));
        dots.add(new Land(7, 11, 1000));
        dots.add(new Land(7, 10, 1000));
        dots.add(new Land(7, 9, 1000));
        dots.add(new Land(7, 8, 1000));
        dots.add(new Land(7, 7, 1000));
        dots.add(new Land(7, 6, 1000));
        dots.add(new Land(7, 5, 1000));
        dots.add(new Land(7, 4, 1000));
        dots.add(new Land(7, 3, 1000));
        dots.add(new Land(7, 2, 1000));
        dots.add(new Land(7, 1, 1000));

        dots.add(new Audit(7, 0));

        dots.add(new FinanceRoom(6, 0, 30));
        dots.add(new FinanceRoom(5, 0, 50));
        dots.add(new FinanceRoom(4, 0, 80));
        dots.add(new FinanceRoom(3, 0, 80));
        dots.add(new FinanceRoom(2, 0, 50));
        dots.add(new FinanceRoom(1, 0, 30));
    }

    public String mapString() {
        String map[][] = new String[mapHeight][mapWidth];
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
        throw new IllegalArgumentException("dot " + current.toString() + " is not in the map");
    }

    public Dot dotAt(int pos) {
        return dots.get(pos);
    }

    private int dotsNum() {
        return (mapHeight + mapWidth) * 2 - 4;
    }
}
