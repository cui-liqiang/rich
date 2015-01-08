package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {
    private RichMap richMap = new RichMap();

    @Test
    public void should_move_by_step() {
        Dot startingPoint = richMap.startingDot();

        Player player = new Player("A", startingPoint, 1000);
        player.moveTo(richMap.getEventfulDotAfter(startingPoint, 4).getDot());

        assertThat(player.locatingDot, sameInstance(richMap.dotAt(4)));
        assertThat(startingPoint.isInclude(player), is(false));
    }
}
