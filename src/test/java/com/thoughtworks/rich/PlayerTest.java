package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest extends IOTestBase{
    private RichMap richMap = new RichMap();

    @Test
    public void should_move_by_step() {
        setInput("Y\n");

        Dot startingPoint = richMap.startingDot();

        Player player = new Player("A", startingPoint);
        player.move(4, richMap);

        assertThat(player.locatingDot, sameInstance(richMap.dotAt(4)));
        assertThat(startingPoint.isInclude(player), is(false));
    }
}
