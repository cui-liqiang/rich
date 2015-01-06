package com.thoughtworks.rich;

import com.thoughtworks.rich.dots.Dot;
import com.thoughtworks.rich.dots.Land;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class RichMapTest {
    RichMap map = new RichMap();

    @Test
    public void should_get_dot_after_steps() {
        Dot targetDot = map.nStepsAfterDot(map.dotAt(3), 6);
        assertThat(targetDot, sameInstance(map.dotAt(9)));
    }

    @Test
    public void should_get_dot_within_scope() {
        //max dot index is 69
        Dot lastDotInMap = map.dotAt(69);
        Dot targetDot = map.nStepsAfterDot(lastDotInMap, 2);

        assertThat(targetDot, sameInstance(map.dotAt(1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_dot_is_not_in_map() {
        Land landNotInMap = new Land(0, 1, 2, 100);
        int anyStep = 3;

        map.nStepsAfterDot(landNotInMap, anyStep);
    }
}
