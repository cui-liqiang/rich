package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.*;
import com.thoughtworks.rich.event.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RichMap {
    public final static int MAP_WIDTH = 29;
    public final static int MAP_HEIGHT = 8;
    List<EventfulDot> eventfulDots = new ArrayList<EventfulDot>();

    public RichMap() {
        int no = 0;

        eventfulDots.add(new EventfulStartDot(new StartDot(no++)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));
        eventfulDots.add(new EventfulLand(new Land(no++, 200)));

        eventfulDots.add(new EventfulHospital(new Hospital(no++)));

        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));
        eventfulDots.add(new EventfulLand(new Land(no++, 400)));

        eventfulDots.add(new EventfulMall(new Mall(no++, 0, 30)));

        eventfulDots.add(new EventfulLand(new Land(no++, 600)));
        eventfulDots.add(new EventfulLand(new Land(no++, 600)));
        eventfulDots.add(new EventfulLand(new Land(no++, 600)));
        eventfulDots.add(new EventfulLand(new Land(no++, 600)));
        eventfulDots.add(new EventfulLand(new Land(no++, 600)));
        eventfulDots.add(new EventfulLand(new Land(no++, 600)));

        eventfulDots.add(new EventfulMall(new Mall(no++, 0, 50)));

        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));
        eventfulDots.add(new EventfulLand(new Land(no++, 800)));

        eventfulDots.add(new EventfulChinaListening(new ChinaListening(no++)));

        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));
        eventfulDots.add(new EventfulLand(new Land(no++, 1000)));

        eventfulDots.add(new EventfulAudit(new Audit(no++)));

        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no++, 30)));
        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no++, 50)));
        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no++, 80)));
        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no++, 80)));
        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no++, 50)));
        eventfulDots.add(new EventfulFinanceRoom(new FinanceRoom(no, 30)));
    }

    public String mapString() {
        String map[][] = new String[MAP_HEIGHT][MAP_WIDTH];
        for (String[] rows : map) {
            Arrays.fill(rows, " ");
        }

        for (EventfulDot dot : eventfulDots) {
            dot.getDot().fillMap(map);
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
        return eventfulDots.get(0).getDot();
    }

    public EventfulDot getEventfulDotAfter(Dot current, int steps) {
        for (int i = 0; i < eventfulDots.size(); i++) {
            if (eventfulDots.get(i).getDot() == current) {
                return eventfulDots.get(((i + steps) % eventfulDotsNum()));
            }
        }
        throw new IllegalArgumentException("locatingDot " + current.toString() + " is not in the map");
    }

    public Dot dotAt(int pos) {
        return eventfulDots.get(pos).getDot();
    }

    private int eventfulDotsNum() {
        return (MAP_HEIGHT + MAP_WIDTH) * 2 - 4;
    }

}
