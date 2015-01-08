package com.thoughtworks.rich;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class DiceTest {
    @Test
    public void should_give_different_point_within_range() {
        Dice dice = new Dice(6);
        int i = 0;
        int lastOne = dice.roll();
        boolean hasDifferent = false;
        while(i++ < 100) {
            int roll = dice.roll();
            assertThat(roll, lessThanOrEqualTo(6));
            assertThat(roll, greaterThanOrEqualTo(1));
            if(!hasDifferent && roll != lastOne) {
                hasDifferent = true;
            }
        }
    }
}
