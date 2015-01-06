package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;
import com.thoughtworks.rich.dots.Land;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {
    private RichMap richMap = new RichMap();

    @Test
    public void should_move_by_step() {
        Dot startingPoint = richMap.startingPoint();
        Player player = new Player("A", startingPoint);
        player.move(4, richMap);

        assertThat(player.locatingDot, equalTo((Dot)new Land(0, 4, 100)));
        assertThat(player.locatingDot, sameInstance(richMap.dotAt(4)));
        assertThat(startingPoint.isInclude(player), is(false));
    }
}
