package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Land;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private RichMap richMap = new RichMap();

    @Test
    public void should_move_by_step() {
        Player player = new Player("A", richMap.startingPoint());
        player.move(4, richMap);

        assertEquals(new Land(0, 4, 100), player.dot);
        assertThat(player.dot, sameInstance(richMap.dotAt(4)));
    }
}
