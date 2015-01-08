package com.thoughtworks.rich.event;

import com.thoughtworks.rich.IOTestBase;
import com.thoughtworks.rich.Player;
import com.thoughtworks.rich.dots.Land;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventfulLandTest extends IOTestBase{
    Land land = new Land(0, 200);
    EventfulLand eventfulLand = new EventfulLand(land);
    int initAmountOfMoney = 1000;
    Player player = new  Player("A", land, initAmountOfMoney);

    @Test
    public void should_be_able_to_choose_to_buy() {
        setInput("Y\n");

        eventfulLand.handleEvent(player);

        assertTrue(land.isOwnedBy(player));
        assertThat(player.getAmountOfMoney(), is(800));
    }

    @Test
    public void should_be_able_to_choose_not_to_buy() {
        setInput("N\n");

        eventfulLand.handleEvent(player);

        assertFalse(land.isOwnedBy(player));
        assertThat(player.getAmountOfMoney(), is(initAmountOfMoney));
    }

    @Test(timeout = 100)
    public void should_prompt_no_enough_money_if_player_cannot_afford_the_land() {
        int lessThanLandPrice = 100;
        int originalAmountOfMoney = lessThanLandPrice;
        Player player = new  Player("A", land, lessThanLandPrice);

        eventfulLand.handleEvent(player);

        assertFalse(land.isOwnedBy(player));
        assertThat(player.getAmountOfMoney(), is(originalAmountOfMoney));
        String prompt = "没有足够的余额，无法购买该土地";
        assertOuputContains(prompt);
    }
}
