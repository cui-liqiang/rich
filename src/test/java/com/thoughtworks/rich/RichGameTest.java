package com.thoughtworks.rich;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RichGameTest extends IOTestBase{
    Dice mockDice = mock(Dice.class);
    RichGame richGame = new RichGame(mockDice);

    @Test
    public void should_be_able_to_draw_map() {
        setInputWithDefaultRoles("\n");
        richGame.run();

        String map = "S0000000000000Y0000000000000Z\n" +
                    "$                           0\n" +
                    "$                           0\n" +
                    "$                           0\n" +
                    "$                           0\n" +
                    "$                           0\n" +
                    "$                           0\n" +
                    "J0000000000000T0000000000000Z\n";

        assertOutputContains(map);
    }

    @Test
    public void should_be_able_to_quit() {
        setInputWithDefaultRoles("quit\n");
        richGame.run();

        assertOutputContains("游戏结束\n");
    }

    @Test
    public void should_be_able_to_work_for_single_player_named_A() {
        setInputWithDefaultRoles("work\n");
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
        assertOutputContains(mapWithPlayer);
    }

    @Test
    public void should_trigger_buying_land_event_when_enter_a_land_without_owner() {
        setInputWithDefaultRoles("work\n" +
                "Y\n"); //confirm to by a land);
        when(mockDice.roll()).thenReturn(4);
        richGame.run();

        assertOutputContains("你已经购得4号房产，花费200元");
    }

    @Test
    public void should_be_able_to_choose_players() {
        setInputWithRoles("ABC",
                "work\nN\n\n" +
                        "work\nN\n\n" +
                        "work\nN\n\n");
        when(mockDice.roll()).thenReturn(2, 3, 4);

        richGame.run();

        String promptToSelectUsers = "请选择玩家[A:赵小A, B:钱小B, C:孙小C]";
        String finalPrintedMap = "S0ABC000000000Y0000000000000Z\n" +
                                "$                           0\n" +
                                "$                           0\n" +
                                "$                           0\n" +
                                "$                           0\n" +
                                "$                           0\n" +
                                "$                           0\n" +
                                "J0000000000000T0000000000000Z\n";
        assertOutputContains(promptToSelectUsers, finalPrintedMap);
    }
}
