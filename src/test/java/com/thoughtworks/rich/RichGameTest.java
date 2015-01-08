package com.thoughtworks.rich;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RichGameTest extends IOTestBase{
    Dice mockDice = mock(Dice.class);
    RichGame richGame = new RichGame(mockDice);

    @Test
    public void should_be_able_to_draw_map() {
        setInput("\n");
        richGame.run();

        String map = "S0000000000000Y0000000000000Z\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "$                           0\n" +
                "J0000000000000T0000000000000Z\n";

        assertOuputContains(map);
    }

    @Test
    public void should_be_able_to_quit() {
        setInput("quit\n");
        richGame.run();

        assertOuputContains("游戏结束\n");
    }

    @Test
    public void should_be_able_to_work_for_single_player_named_A() {
        setInput("work\n");
        when(mockDice.roll()).thenReturn(4);
        richGame.run();

        String mapWithPlayer = "S000A000000000Y0000000000000Z\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "$                           0\n" +
                               "J0000000000000T0000000000000Z\n";
        assertOuputContains(mapWithPlayer);
    }

    @Test
    public void should_trigger_buying_land_event_when_enter_a_land_without_owner() {
        setInput("work\n" +
                "Y\n"); //confirm to by a land);
        when(mockDice.roll()).thenReturn(4);
        richGame.run();

        assertOuputContains("你已经购得4号房产，花费200元");
    }

}
